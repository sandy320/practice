package com.kitchen.service;

import com.kitchen.entity.Courier;
import com.kitchen.entity.Order;
import com.kitchen.listener.DeliveryEvent;
import com.kitchen.strategy.FifoPickStrategy;
import com.kitchen.strategy.MatchedPickStrategy;
import com.kitchen.strategy.PickStrategy;
import com.kitchen.task.CourierTask;
import com.kitchen.task.OrderTask;
import com.kitchen.util.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The kitchen system, receive orders and delivery
 */
public class KitchenSystem {

    /**
     * The current courier pick up strategy
     */
    PickStrategy pickStrategy;

    /**
     * The order put in it for prepare
     */
    private volatile Map<String, Order> kitchen;

    /**
     * The pool store the ready order
     */
    private volatile Map<String, Order> orderWaitPool;

    /**
     * The pool for matched strategy courier
     */
    private volatile Map<String, Courier> matchedWaitPool;

    /**
     * The pool for FIFO strategy courier
     */
    private volatile Queue<Courier> fifoWaitPool;

    /**
     * Store the schedued task result
     */
    private List<Future<DeliveryEvent>> futures;

    /**
     * The total order wait time
     */
    private long totalOrderWaitTime;

    /**
     * The total courier wait time
     */
    private long totalCourierWaitTime;

    /**
     * Record the courier delay, only for test
     */
    public Map<String, Integer> courierArriveTime = new HashMap<>();

    public KitchenSystem() {
        kitchen = new ConcurrentHashMap<>();
        orderWaitPool = new ConcurrentHashMap<>();
        futures = new ArrayList<>();
        matchedWaitPool = new ConcurrentHashMap<>();
        fifoWaitPool = new LinkedList<>();
        pickStrategy = new FifoPickStrategy(this);
    }

    /**
     * Simulate the kitchen receive the new order to prepare
     * It will schedule 2 tasks
     * OrderTask: Send an order to kitchen
     * CourierTask: Dispatch a courier to pick up order
     *
     * @param order
     */
    public void addOrder(Order order) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        // Send order to kitchen
        //System.out.println("Receive order " + order.getName() + " for prepare at " + new Date() + " and will be ready in " + order.getPrepTime() + "s.");
        kitchen.put(order.getId(), order);
        OrderTask orderTask = new OrderTask(order, this);
        Future<DeliveryEvent> orderFuture = scheduledExecutorService.schedule(orderTask, 0, TimeUnit.SECONDS);
        futures.add(orderFuture);

        // Dispatch courier
        int delay = Utils.getRandomInt(3, 8);
        courierArriveTime.put(order.getId(), delay);
        Courier courier = new Courier(order.getId());
        CourierTask courierTask = new CourierTask(courier, this);
        Future<DeliveryEvent> courierFuture = scheduledExecutorService.schedule(courierTask, delay, TimeUnit.SECONDS);
        futures.add(courierFuture);
    }

    /**
     * Once order is ready, move the order to wait pool
     *
     * @param order
     */
    public void moveOrderToWaitPool(Order order) {
        kitchen.remove(order.getId());
        orderWaitPool.put(order.getId(), order);
    }

    /**
     * Use for main thread, wait for every sub thread done
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void waitToFinish() throws ExecutionException, InterruptedException {
        int cnt = 0;
        for (Future<DeliveryEvent> future : futures) {
            DeliveryEvent event = future.get();
            if (event.isDelivered()) {
                cnt++;
                long orderWaitTime = event.getOrderWaitTime();
                long courierWaitTime = event.getCourierWaitTime();
                totalOrderWaitTime += orderWaitTime;
                totalCourierWaitTime += courierWaitTime;
                System.out.println("=================================================");
                System.out.println("Order: " + event.getOrder()
                                                    .getName() + "|Order wait: " + orderWaitTime + "ms|Courier wait: " + courierWaitTime + "ms");
                System.out.println("Order avg wait: " + totalOrderWaitTime / cnt + "ms|Courier avg wait: " + totalCourierWaitTime / cnt + "ms");
            }
        }
    }

    public PickStrategy getPickStrategy() {
        return pickStrategy;
    }

    public Map<String, Order> getKitchen() {
        return kitchen;
    }

    public Map<String, Order> getOrderWaitPool() {
        return orderWaitPool;
    }

    public Map<String, Courier> getMatchedWaitPool() {
        return matchedWaitPool;
    }

    public Queue<Courier> getFifoWaitPool() {
        return fifoWaitPool;
    }
}
