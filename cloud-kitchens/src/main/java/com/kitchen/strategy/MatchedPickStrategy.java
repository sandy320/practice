package com.kitchen.strategy;

import com.kitchen.entity.Courier;
import com.kitchen.entity.Order;
import com.kitchen.mq.CourierQueue;
import com.kitchen.mq.FifoQueue;
import com.kitchen.mq.MatchedQueue;
import com.kitchen.task.DeliveryEvent;
import com.kitchen.service.KitchenSystem;
import com.kitchen.util.Utils;

import java.util.Date;
import java.util.Map;

public class MatchedPickStrategy implements PickStrategy {

    private KitchenSystem kitchenSystem;

    public MatchedPickStrategy(KitchenSystem kitchenSystem) {
        this.kitchenSystem = kitchenSystem;
    }

    /**
     * The specified order is ready, the courier could pick it up immediately
     *
     * @param courier
     */
    @Override
    public DeliveryEvent pickup(Courier courier) {
        Map<String, Order> readyOrders = kitchenSystem.getOrderWaitPool();
        DeliveryEvent event = new DeliveryEvent();
        if (readyOrders.containsKey(courier.getOrderId())) {
            // The specified order is ready, the courier could pick it up immediately
            // The courier waitTime is 0
            // The order waitTime is courier arrived timestamp - order ready timestamp
            Order order = readyOrders.get(courier.getOrderId());
            event.setOrderWaitTime(courier.getArriveTime() - order.getReadyTime());
            event.setDelivered(true);
            event.setOrder(order);
            readyOrders.remove(courier.getOrderId());
        } else {
            // Courier arrives at kitchen first, the order is not ready
            // Put the courier to wait pool
            kitchenSystem.addCourier(courier);
        }
        return event;
    }

    /**
     * There is courier waiting for long time, the order could be delivered immediately
     *
     * @param order
     * @return
     */
    @Override
    public DeliveryEvent pickup(Order order) {
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
     * Return the MatchedQueue
     *
     * @return
     */
    @Override
    public CourierQueue newCourierQueue() {
        return new MatchedQueue();
    }

    @Override
    public String getName() {
        return "Matched";
    }
}
