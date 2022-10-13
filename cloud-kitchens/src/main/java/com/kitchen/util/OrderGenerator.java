package com.kitchen.util;

import com.kitchen.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderGenerator {

    /**
     * Generate order list with count size
     *
     * @param count
     * @return
     */
    public static List<Order> generateOrder(int count) {
        List<Order> orders = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            Order order = new Order("No." + i, "Food" + i, 1 + r.nextInt(6));
            orders.add(order);
        }
        return orders;
    }
}
