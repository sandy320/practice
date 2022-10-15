package com.kitchen.strategy;

import com.kitchen.entity.Courier;
import com.kitchen.entity.Order;
import com.kitchen.mq.CourierQueue;
import com.kitchen.mq.FifoQueue;
import com.kitchen.task.DeliveryEvent;
import com.kitchen.service.KitchenSystem;
import com.kitchen.util.Utils;

import java.util.Date;
import java.util.Map;

public class FifoPickStrategy implements PickStrategy {

    private KitchenSystem kitchenSystem;

    public FifoPickStrategy(KitchenSystem kitchenSystem) {
        this.kitchenSystem = kitchenSystem;
    }

    /**
     * There are some orders ready, the courier could pick up random one immediately
     *
     * @param courier
     */
    @Override
    public synchronized DeliveryEvent pickup(Courier courier) {
        DeliveryEvent event = new DeliveryEvent();
        Map<String, Order> readyOrders = kitchenSystem.getOrderWaitPool();
        if (!readyOrders.isEmpty()) {
            // There are some orders ready, the courier could pick up random one immediately
            // The courier waitTime is 0
            // The order waitTime is courier arrived timestamp - order ready timestamp
            String randomOrderId = Utils.getRandomKey(kitchenSystem.getOrderWaitPool());
            Order order = readyOrders.get(randomOrderId);
            event.setOrderWaitTime(courier.getArriveTime() - order.getReadyTime());
            event.setDelivered(true);
            event.setOrder(order);
            readyOrders.remove(randomOrderId);
        } else {
            // Courier arrives at kitchen first, the order is not ready
            // Put the courier to wait pool
            kitchenSystem.addCourier(courier);
        }
        return event;
    }

    /**
     * There are couriers waiting for long time, the order could be delivered immediately
     * The queue empty check and poll is atom action
     * Avoid the scenario:
     * There is one element in queue
     * Thread1 check the queue is not empty, -----------------------> poll from empty queue --> NPE
     * Thread2 check the queue is not empty, poll faster than thread1
     *
     * @param order
     * @return
     */
    @Override
    public synchronized DeliveryEvent pickup(Order order) {
        // Check if there is already courier waiting
        DeliveryEvent event = new DeliveryEvent();
        if (kitchenSystem.hasAvailableCourier(order.getId())) {
            // There is courier waiting for long time, the order could be delivered immediately
            // So the order waitTime is 0
            // The courier wait time = order ready timestamp - courier arrive time
            Courier pickCourier = kitchenSystem.pollCourier(order.getId());
            event.setDelivered(true);
            event.setCourierWaitTime(order.getReadyTime() - pickCourier.getArriveTime());
            event.setOrder(order);
            kitchenSystem.getKitchen()
                         .remove(order.getId());
        } else {
            // The courier does not arrive yet, move the order to wait
            kitchenSystem.moveOrderToWaitPool(order);
        }
        return event;
    }


    /**
     * Return the FifoQueue
     *
     * @return
     */
    @Override
    public CourierQueue newCourierQueue() {
        return new FifoQueue();
    }

    @Override
    public String getName() {
        return "FIFO";
    }
}
