package com.kitchen.task;

import com.kitchen.entity.Order;
import com.kitchen.service.KitchenSystem;
import com.kitchen.util.Utils;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Simulate the kitchen receive the order and prepare to ready task
 */
public class OrderTask implements Callable<DeliveryEvent> {

    private Order order;

    private KitchenSystem kitchenSystem;

    public OrderTask() {

    }

    public OrderTask(Order order, KitchenSystem kitchenSystem) {
        this.order = order;
        this.kitchenSystem = kitchenSystem;
    }

    /**
     * Simulate the order prepare process
     *
     * @return @Order with ready timestamp
     * @throws Exception
     */
    @Override
    public DeliveryEvent call() throws Exception {
        // Prepare
        Thread.sleep(order.getPrepTime() * 1000);

        // Record the order ready timestamp
        order.setReadyTime(System.currentTimeMillis());
        System.out.println(Utils.formatDate(new Date()) + ": Order " + order.getName() + " is prepared");

        DeliveryEvent event = kitchenSystem.getPickStrategy()
                                           .pickup(order);
        if(event.isDelivered()){
            System.out.println(Utils.formatDate(new Date()) + ": Order delivered |Order wait: " + event.getOrderWaitTime() + "ms|Courier wait: " + event.getCourierWaitTime() + "ms");
        }
        return event;
    }
}
