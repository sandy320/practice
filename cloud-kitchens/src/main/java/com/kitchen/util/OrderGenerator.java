package com.kitchen.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitchen.entity.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class OrderGenerator {

    /**
     * Generate the orders from given file
     *
     * @param path
     * @return
     */
    public static List<Order> generateOrder(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        File file = new File(path);
        InputStream ins = null;

        if (file.exists()) {
            ins = new FileInputStream(file);
        } else {
            ins = Utils.class.getResourceAsStream(Const.DEFAULT_DATA_FILE);
        }
        List<Order> orders = mapper.readValue(ins, new TypeReference<List<Order>>() {});
        return orders;
    }

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
