package com.wbchao.leetcode;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/sort-characters-by-frequency/
public class SortCharactersByFrequency451 {

    public String frequencySort(String s) {
        int[] map = new int[62];
        char[] str = s.toCharArray();
        for (char c : str) {
            if ('0' <= c && c <= '9') {
                map[c - '0']++;
            } else if ('a' <= c && c <= 'z') {
                map[c - 'a' + 10]++;
            } else {
                map[c - 'A' + 36]++;
            }
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                priorityQueue.add(new int[]{i, map[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            char c = (char) (cur[0] < 10 ? cur[0] + '0' : (cur[0] < 36 ? cur[0] - 10 + 'a' : cur[0] - 36 + 'A'));
            int size = cur[1];
            for (int i = 0; i < size; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
