package com.kitchen;

import com.kitchen.entity.Order;
import com.kitchen.service.KitchenSystem;
import com.kitchen.strategy.FifoPickStrategy;
import com.kitchen.strategy.PickStrategy;
import com.kitchen.util.Const;
import com.kitchen.util.OrderGenerator;
import com.kitchen.util.PropertyMgr;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Application {

    /**
     * Then entrance for simulation
     * Strategy could be set by args or properties
     * Or else will be FIFO strategy as default
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        PickStrategy pickStrategy;
        KitchenSystem kitchenSystem = new KitchenSystem();
        int n = Const.ORDER_CNT_PERSECOND;
        String strategyClassName = Const.DEFAULT_STRATEGY;
        int courierEarliest = Const.COURIER_EARLIEST;
        int courierLatest = Const.COURIER_LATEST;
        String dataFile = Const.DEFAULT_DATA_FILE;
        List<Order> orders = new ArrayList<>();

        // Read the configuration from args or properties file
        try {
            if (args.length > 0) {
                strategyClassName = args[0];
            } else if (PropertyMgr.get("strategy") != null) {
                strategyClassName = PropertyMgr.get("strategy");
            }
        } catch (Exception e) {
            System.out.println("Got exception on read config strategy, will use default.");
        }
        try {
            if (args.length > 1) {
                dataFile = args[1];
            } else if (PropertyMgr.get("data.file") != null) {
                dataFile = PropertyMgr.get("data.file");
            }
        } catch (Exception e) {
            System.out.println("Got exception on read config order rate, will use default.");
        }

        try {
            if (args.length > 2) {
                n = Integer.parseInt(args[2]);
            } else if (PropertyMgr.get("order.cnt.persecond") != null) {
                n = Integer.parseInt(PropertyMgr.get("order.cnt.persecond"));
            }
        } catch (Exception e) {
            System.out.println("Got exception on read config order rate, will use default.");
        }

        try {
            if (args.length > 3) {
                courierEarliest = Integer.parseInt(args[3]);
            } else if (PropertyMgr.get("courier.earliest") != null) {
                courierEarliest = Integer.parseInt(PropertyMgr.get("courier.earliest"));
            }
        } catch (Exception e) {
            System.out.println("Got exception on read config courier earliest arrive time, will use default.");
        }
        try {
            if (args.length > 4) {
                courierLatest = Integer.parseInt(args[4]);
            } else if (PropertyMgr.get("courier.latest") != null) {
                courierLatest = Integer.parseInt(PropertyMgr.get("courier.latest"));
            }
        } catch (Exception e) {
            System.out.println("Got exception on read config courier latest arrive time, will use default.");
        }

        // Check the config is valid
        if (n < 0) {
            System.out.println("Order per second should be > 0");
            n = Const.ORDER_CNT_PERSECOND;
        }
        if (courierEarliest < 0 || courierLatest < 0 || courierLatest < courierEarliest) {
            System.out.println("Courier arrived time error");
            courierEarliest = Const.COURIER_EARLIEST;
            courierLatest = Const.COURIER_LATEST;
        }
        try {
            Class cls = Class.forName(strategyClassName);
            Constructor constructor = cls.getConstructor(KitchenSystem.class);
            pickStrategy = (PickStrategy) constructor.newInstance(kitchenSystem);
        } catch (Exception e) {
            System.out.println("Set strategy error");
            Class cls = Class.forName(Const.DEFAULT_STRATEGY);
            Constructor constructor = cls.getConstructor(KitchenSystem.class);
            pickStrategy = (PickStrategy) constructor.newInstance(kitchenSystem);
        }

        try {
            // Read orders from data file
            orders = OrderGenerator.generateOrder(dataFile);
        } catch (Exception e) {
            System.out.println("Read data file error, the kitchen system could not start!");
            System.exit(1);
        }
        // Init the kitchens config
        kitchenSystem.init(pickStrategy, courierEarliest, courierLatest);

        System.out.println("Kitchen Service start with " + pickStrategy.getName() + "...");
        System.out.println("Order will be received " + n + " per second");
        System.out.println("Courier will arrive in " + courierEarliest + "-" + courierLatest + "s after dispatched");
        System.out.println("===========================================");
        //Start send orders to kitchen
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            kitchenSystem.addOrder(order);
            if (i % n == n - 1) {
                Thread.sleep(1000);
            }
        }
        kitchenSystem.waitToFinish();
        System.out.println("Kitchen Service closed...");
        System.exit(0);
    }
}