package com.wbchao.leetcode.offer;

import java.util.Arrays;

public class Offer60 {

    public static void main(String[] args) {
        System.out.println(dicesProbability(2));
    }

    public static double[] dicesProbability(int n) {
        int total = 0;
        int sum = (int) Math.pow(6d, n);
        for (int i = n; i <= 6 * n; i++) {
            total++;
        }
        double[] ans = new double[total];
        System.out.println(ans.length);
        process(n, 1, 0, ans);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i] / sum;
        }
        return ans;
    }

    public static void process(int n, int index, int preSum, double[] ans) {
        if (index == n + 1) {
            ans[preSum - n]++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            process(n, index + 1, preSum + i, ans);
        }
    }
}
