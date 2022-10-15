package com.kitchen.strategy;

import com.kitchen.entity.Courier;
import com.kitchen.entity.Order;
import com.kitchen.mq.CourierQueue;
import com.kitchen.service.KitchenSystem;
import com.kitchen.task.DeliveryEvent;

public interface PickStrategy {

    /**
     * Courier could pick up the order with no wait
     *
     * @param courier
     * @return
     */
    DeliveryEvent pickup(Courier courier);

    /**
     * Order could be pick up with no wait
     *
     * @param order
     * @return
     */
    DeliveryEvent pickup(Order order);

    /**
     * Return the courier queue with exactly strategy
     *
     * @return
     */
    CourierQueue newCourierQueue();

    /**
     * Return the strategy name
     *
     * @return
     */
    String getName();
}
