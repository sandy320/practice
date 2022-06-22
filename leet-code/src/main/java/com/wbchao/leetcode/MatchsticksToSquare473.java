package com.wbchao.leetcode;

import java.util.Arrays;

public class MatchsticksToSquare473 {

    public static void main(String[] args) {
        int[] box = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8};
        System.out.println(makesquare(box));
    }

    public static boolean makesquare(int[] matchsticks) {
        int N = matchsticks.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int R = sum / 4;
        for (int i = 0; i < N; i++) {
            if (matchsticks[i] > R) {
                return false;
            }
        }
        return process(matchsticks, R, 0, new int[4]);
    }

    public static boolean process(int[] matchsticks, int R, int index, int[] edges) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= R && process(matchsticks, R, index + 1, edges)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
