package com.wbchao.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class NextGreaterElementiii556 {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12222333));
    }

    public static int nextGreaterElement(int n) {
        int cur = n;
        int size = 0;
        while (cur != 0) {
            size++;
            cur /= 10;
        }
        int[] arr = new int[size];
        cur = n;
        while (cur != 0) {
            arr[size - 1] = cur % 10;
            cur /= 10;
            size--;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        map.put(arr[arr.length - 1], arr.length - 1);
        priorityQueue.add(arr[arr.length - 1]);
        int i = arr.length - 2;
        int poll = -1;
        for (; i >= 0; i--) {
            priorityQueue.add(arr[i]);
            if (map.get(arr[i]) == null) {
                map.put(arr[i], i);
            }
            if (arr[i] < arr[i + 1]) {
                poll = map.higherKey(arr[i]);
                int j = map.get(poll);
                swap(arr, i, j);
                break;
            }
        }
        if (poll == -1) {
            return -1;
        }
        boolean flag = true;
        while (!priorityQueue.isEmpty()) {
            int curDigit = priorityQueue.poll();
            if (curDigit == poll && flag) {
                flag = false;
            } else {
                arr[++i] = curDigit;
            }
        }
        return toNumber(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int toNumber(int[] arr) {
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans *= 10;
            ans += arr[i];
        }
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }
}
