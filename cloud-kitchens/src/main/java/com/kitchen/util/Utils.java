package com.kitchen.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils {

    /**
     * Return the random key of Map
     *
     * @param map
     * @return
     */
    public static String getRandomKey(Map map) {
        List list = (List) map.keySet()
                              .stream()
                              .collect(Collectors.toList());
        Random r = new Random();
        return (String) list.get(r.nextInt(list.size()));
    }

    /**
     * Return the random value in [min, max]
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        int gap = max - min + 1;
        return min + r.nextInt(gap);
    }

    /**
     * Formate date for easy read
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }
}
