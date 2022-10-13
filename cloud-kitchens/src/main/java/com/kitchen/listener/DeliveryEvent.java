package com.kitchen.listener;


import com.kitchen.entity.Order;

/**
 *  When order is delivery, will send wait time to kitchen system
 *
 */
public class DeliveryEvent {

    /**
     * The order has delivered
     */
    private Order order;

    /**
     *  The order wait such second to be picked up
     *
     */
    private long orderWaitTime;

    /**
     *  The courier wait such second to pick the order up
     *
     */
    private long courierWaitTime;

    /**
     *  Whether the order is deliveried or not
     *
     */
    private boolean delivered;

    public long getOrderWaitTime() {
        return orderWaitTime;
    }

    public void setOrderWaitTime(long orderWaitTime) {
        this.orderWaitTime = orderWaitTime;
    }

    public long getCourierWaitTime() {
        return courierWaitTime;
    }

    public void setCourierWaitTime(long courierWaitTime) {
        this.courierWaitTime = courierWaitTime;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
