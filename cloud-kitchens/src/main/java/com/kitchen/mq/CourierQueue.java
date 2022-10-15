package com.kitchen.mq;

import com.kitchen.entity.Courier;

/**
 * The queue for every courier stratege
 *
 */
public interface CourierQueue {

    /**
     * Return if there is available courier can pick up the order
     *
     * @param orderId
     * @return
     */
    boolean hasCandidate(String orderId);

    /**
     * Poll the available courier to pick up order
     *
     * @param orderId
     * @return
     */
    Courier poll(String orderId);

    /**
     * Add a courier to queue
     *
     * @param courier
     */
    void add(Courier courier);
}
