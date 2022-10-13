package com.kitchen.strategy;

import com.kitchen.entity.Courier;
import com.kitchen.entity.Order;
import com.kitchen.listener.DeliveryEvent;
import com.kitchen.service.KitchenSystem;

public interface PickStrategy {

    /**
     *  Courier could pick up the order with no wait
     *
     * @param courier
     * @return
     */
    DeliveryEvent pickup(Courier courier);

    /**
     *  Order could be pick up with no wait
     *
     * @param order
     * @return
     */
    DeliveryEvent pickup(Order order);
}
