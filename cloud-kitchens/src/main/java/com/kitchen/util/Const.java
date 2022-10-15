package com.kitchen.util;

public class Const {

    // Default strategy class
    public static final String DEFAULT_STRATEGY = "com.kitchen.strategy.FifoPickStrategy";

    // Default order receieve rate, 2 orders/s
    public static final int ORDER_CNT_PERSECOND = 2;

    // Default courier earliest arrive time
    public static final int COURIER_EARLIEST = 3;

    // Default courier latest arrive time
    public static final int COURIER_LATEST = 15;

    // Data file
    public static final String DEFAULT_DATA_FILE = "/dispatch_orders.json";
}
