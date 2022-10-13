package com.kitchen.entity;

public class Courier {

    /**
     * This courier is sent by which order
     */
    private String orderId;

    /**
     * The timestamp courier arrive at kitchen
     *
     */
    private long arriveTime;

    public Courier(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(long arriveTime) {
        this.arriveTime = arriveTime;
    }
}
