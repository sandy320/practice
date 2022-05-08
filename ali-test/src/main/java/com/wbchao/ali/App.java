package com.wbchao.ali;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 4};
        sort(arr);
        Arrays.stream(arr).forEach(s -> System.out.println(s));
    }


    public int[] insert(int[] orders, int position, int dist) {
        if (orders == null || orders.length == 0) {
            return new int[]{dist};
        }
        int[] result = new int[orders.length + 1];
        if (position > orders.length) {
            for (int i = 0; i < orders.length; i++) {
                result[i] = orders[i];
            }
            result[result.length - 1] = dist;
            return result;
        }
        int j = 0;
        for (int i = 0; i < result.length; i++) {
            if (i == position) {
                result[i] = dist;
            } else {
                result[i] = orders[j];
                j++;
            }
        }
        return result;
    }

    public static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
