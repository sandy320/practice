package com.kitchen;


import com.kitchen.entity.Order;
import com.kitchen.service.KitchenSystem;
import com.kitchen.util.OrderGenerator;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class KitchenSystemTest {

    private KitchenSystem kitchenSystem = new KitchenSystem();


    @Test
    public void testSendOrder() throws InterruptedException, ExecutionException {
        List<Order> orders = OrderGenerator.generateOrder(10);
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            kitchenSystem.addOrder(order);
//            if (i % 2 == 1) {
//                System.out.println("Sleep 1s...");
//                Thread.sleep(1000);
//            }
        }

        kitchenSystem.waitToFinish();
        System.out.println("=============================================");
        for (Order order : orders) {
            System.out.println(order.getName() + " prepare " + order.getPrepTime() + "s| arrive " + kitchenSystem.courierArriveTime.get(order.getId()));
        }
        System.out.println("Kitchen: " + kitchenSystem.getKitchen()
                                                      .size());
        System.out.println("Ready: " + kitchenSystem.getOrderWaitPool()
                                                    .size());
    }
}
