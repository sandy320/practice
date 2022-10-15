package com.kitchen.task;

import com.kitchen.entity.Courier;
import com.kitchen.service.KitchenSystem;
import com.kitchen.util.Utils;

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
        System.out.println(Utils.formatDate(new Date()) + ": Courier arrived");
        DeliveryEvent event = kitchenSystem.getPickStrategy()
                                           .pickup(courier);
        if(event.isDelivered()){
            System.out.println(Utils.formatDate(new Date()) + ": Order delivered |Order wait: " + event.getOrderWaitTime() + "ms|Courier wait: " + event.getCourierWaitTime() + "ms");
        }
        return event;
    }
}
