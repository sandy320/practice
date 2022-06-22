package com.wbchao.leetcode.offer;

public class Offer14 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(3));
    }

    public static int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        return process(0, n);
    }

    public static int process(int preCut, int rest) {

        if (rest == 1 || rest == 0) {
            return 1;
        }
        if (rest == 2) {
            return 2;
        }

        int ans = 1;
        for (int i = 2; i <= rest; i++) {
            int newCut = preCut;
            if (i != rest) {
                newCut++;
            }
            int next = process(newCut, rest - i);

            int cur = i * next;
            if (newCut != 0) {
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public static int dp(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static int M = 1000000007;

    public static int dp2(int n) {
        //贪心算法  可以通过数学证明得知当等于3的绳子段数越多，乘积越大
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = (res * 3) % M;
            n -= 3;
        }
        return (int) (res * n % M);
    }
}
