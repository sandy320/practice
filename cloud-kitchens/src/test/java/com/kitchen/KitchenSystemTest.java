package com.kitchen;


import com.kitchen.entity.Order;
import com.kitchen.service.KitchenSystem;
import com.kitchen.strategy.FifoPickStrategy;
import com.kitchen.strategy.PickStrategy;
import com.kitchen.util.OrderGenerator;
import com.kitchen.util.PropertyMgr;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class KitchenSystemTest {

    private KitchenSystem kitchenSystem;


    @Test
    public void testSendOrder() throws InterruptedException, ExecutionException {
        kitchenSystem = new KitchenSystem();
        PickStrategy strategy = new FifoPickStrategy(kitchenSystem);
        kitchenSystem.init(strategy, 3, 15);
        List<Order> orders = OrderGenerator.generateOrder(16);
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            kitchenSystem.addOrder(order);
            if (i % 2 == 1) {
                Thread.sleep(1000);
            }
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

    @Test
    public void testAppArgs() throws Exception {
        String[] args = {"com.kitchen.strategy.MatchedPickStrategy", "abc","-3", "5", "10"};
        Application.main(args);
    }

    @Test
    public void testAppProperties() throws Exception {
        Application.main(new String[]{});
    }

    @Test
    public void testGenerateOrderFromFile() throws Exception {
        String path = "D:\\IdeaProjects\\practice\\cloud-kitchens\\src\\main\\resources\\dispatch_orders.json";
        List<Order> orders1 = OrderGenerator.generateOrder(path);
        List<Order> orders2 = OrderGenerator.generateOrder("path");
        System.out.println(orders1.size());
        System.out.println(orders2.size());
    }

    @Test
    public void testPropertyMgr() {
        System.out.println(PropertyMgr.get("strategy"));
    }
}
