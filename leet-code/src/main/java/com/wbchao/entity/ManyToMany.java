package com.wbchao.entity;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javafx.util.Pair;

/**
 * 查询看了商品A的人还看了其他商品的数目
 *
 */
public class ManyToMany {

    private static List<User> users = new ArrayList<>();
    private static List<Item> items = new ArrayList<>();
    private static String[] itemNames = new String[]{"A", "B", "C", "D", "E", "F", "G"};
    private static Random r = new Random();

    public static void main(String[] args) {
        generateData();
        users.stream()
             .forEach(u -> System.out.println(u));
        User user = users.get(0);
        Item item = (Item) user.getItems()
                               .toArray()[0];
        System.out.println("Searching  " + item.getName());
        Map<Item, Integer> result = users.stream()
                                         .filter(u -> !u.equals(user))//过滤掉自己
                                         .filter(u -> u.getItems()
                                                       .contains(item))//找出其他看过商品A的客户
                                         .map(u -> u.getItems())//提取出每个客户的商品列表
                                         .flatMap(i -> i.stream())//压扁
                                         .filter(i -> !i.equals(item))//除去商品A本身
                                         .map(i -> new Pair<Item, Integer>(i, 1))//标1成对
                                         //第1个参数是reduce返回值类型，第2个参数是函数，其中map就是第一参数中new的HashMap
                                         .reduce(new HashMap<Item, Integer>(), (map, pair) -> {
                                             Integer count = map.get(pair.getKey());
                                             if (count == null) {
                                                 count = 1;
                                             } else {
                                                 count++;
                                             }
                                             map.put(pair.getKey(), count);
                                             return map;
                                         }, (map, pair) -> null);
        System.out.println(result);
        result.entrySet()
              .stream()
              .sorted((e1, e2) -> -e1.getValue()
                                    .compareTo(e2.getValue()))
              .forEach(e -> System.out.println(e));
    }

    public static void generateData() {
        for (int i = 0; i < 5; i++) {
            users.add(new User("u_" + i, "Tom" + i));
        }
        for (int i = 0; i < 7; i++) {
            items.add(new Item("i_" + i, itemNames[i]));
        }

        for (User u : users) {
            for (int i = 0; i < 10; i++) {
                u.addItem(items.get(r.nextInt(7)));
            }
        }
    }
}
