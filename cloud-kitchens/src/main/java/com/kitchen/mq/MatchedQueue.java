package com.kitchen.mq;

import com.kitchen.entity.Courier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Queue for matched courier
 */
public class MatchedQueue implements CourierQueue {

    /**
     * Use map to store
     */
    private volatile Map<String, Courier> map;

    public MatchedQueue() {
        this.map = new ConcurrentHashMap<>();
    }

    /**
     * Reture if has the entry with specified orderId
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean hasCandidate(String orderId) {
        return map.containsKey(orderId);
    }


    /**
     * Return the courier and remove
     *
     * @param orderId
     * @return
     */
    @Override
    public synchronized Courier poll(String orderId) {
        Courier c = map.get(orderId);
        map.remove(orderId);
        return c;
    }

    /**
     * Add a courier to queue
     *
     * @param courier
     */
    @Override
    public void add(Courier courier) {
        map.put(courier.getOrderId(), courier);
    }
}
