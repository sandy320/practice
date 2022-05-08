package com.wbchao.leetcode.offer;

public class Offer47 {

    public int maxValue(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        //二维dp，空间压缩变一维
        int[] dp = new int[N];
        dp[0] = grid[0][0];
        for (int j = 1; j < N; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < M; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < N; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[N - 1];
    }
}
