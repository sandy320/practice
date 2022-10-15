package com.kitchen.mq;

import com.kitchen.entity.Courier;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Queue for FIFO courier
 */
public class FifoQueue implements CourierQueue {

    /**
     * Use queue to store courier
     */
    private volatile Queue<Courier> queue;

    public FifoQueue() {
        this.queue = new LinkedBlockingQueue<>();
    }

    /**
     * Return if the queue is empty
     *
     * @param orderId
     * @return
     */
    @Override
    public boolean hasCandidate(String orderId) {
        return !queue.isEmpty();
    }

    /**
     * Poll the first courier
     *
     * @param orderId
     * @return
     */
    @Override
    public Courier poll(String orderId) {
        return queue.poll();
    }

    /**
     * Add courier to queue
     *
     * @param courier
     */
    @Override
    public void add(Courier courier) {
        queue.add(courier);
    }
}
