package com.wbchao.leetcode.offer;

public class Offer49 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int v2 = 0, v3 = 0, v5 = 0;
        for (int i = 1; i < n; i++) {
            v2 = dp[p2] * 2;
            v3 = dp[p3] * 3;
            v5 = dp[p5] * 5;
            dp[i] = Math.min(v2, Math.min(v3, v5));
            if (dp[i] == v2) {
                p2++;
            }
            if (dp[i] == v3) {
                p3++;
            }
            if (dp[i] == v5) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}
