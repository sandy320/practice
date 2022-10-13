package com.kitchen.strategy;

import com.kitchen.entity.Courier;
import com.kitchen.entity.Order;
import com.kitchen.listener.DeliveryEvent;
import com.kitchen.service.KitchenSystem;

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
            Order deliveryOrder = readyOrders.get(courier.getOrderId());
            event.setOrderWaitTime(courier.getArriveTime() - deliveryOrder.getReadyTime());
            event.setDelivered(true);
            event.setOrder(deliveryOrder);
            readyOrders.remove(courier.getOrderId());
        } else {
            // Courier arrives at kitchen first, the order is not ready
            // Put the courier to wait pool
            kitchenSystem.getMatchedWaitPool()
                         .put(courier.getOrderId(), courier);
        }
        return event;
    }

    /**
     *  There is courier waiting for long time, the order could be delivered immediately
     *
     * @param order
     * @return
     */
    @Override
    public DeliveryEvent pickup(Order order) {
        // Check if there is already courier waiting
        Map<String, Courier> arrivedCouriers = kitchenSystem.getMatchedWaitPool();
        DeliveryEvent event = new DeliveryEvent();
        if (arrivedCouriers.containsKey(order.getId())) {
            // There is courier waiting for long time, the order could be delivered immediately
            // So the order waitTime is 0
            // The courier wait time = order ready timestamp - courier arrive time
            Courier pickCourier = arrivedCouriers.get(order.getId());
            event.setDelivered(true);
            event.setCourierWaitTime(order.getReadyTime() - pickCourier.getArriveTime());
            event.setOrder(order);
            kitchenSystem.getMatchedWaitPool()
                         .remove(order.getId());
            kitchenSystem.getKitchen()
                         .remove(order.getId());
        } else {
            // The courier does not arrive yet, move the order to wait
            kitchenSystem.moveOrderToWaitPool(order);
        }
        return event;
    }

}
