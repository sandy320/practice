package com.kitchen.task;

import com.kitchen.entity.Courier;
import com.kitchen.listener.DeliveryEvent;
import com.kitchen.service.KitchenSystem;

import java.util.Date;
import java.util.concurrent.Callable;

public class CourierTask implements Callable<DeliveryEvent> {

    private Courier courier;
    private KitchenSystem kitchenSystem;

    public CourierTask(Courier courier, KitchenSystem kitchenSystem) {
        this.courier = courier;
        this.kitchenSystem = kitchenSystem;
    }

    @Override
    public DeliveryEvent call() throws Exception {
        courier.setArriveTime(System.currentTimeMillis());
        System.out.println("Courier arrives at " + new Date(courier.getArriveTime()));
        DeliveryEvent event = kitchenSystem.getPickStrategy()
                                           .pickup(courier);
        return event;
    }
}
