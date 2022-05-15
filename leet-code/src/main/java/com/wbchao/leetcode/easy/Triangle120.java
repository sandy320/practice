package com.wbchao.leetcode.easy;

import java.util.List;

public class Triangle120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        return process(triangle, 0, 0);
    }

    public static int process(List<List<Integer>> triangle, int level, int index) {
        if (level == triangle.size()) {
            return 0;
        }

        int ans = triangle.get(level)
                          .get(index);

        int p1 = ans + process(triangle, level + 1, index);
        int p2 = ans + process(triangle, level + 1, index + 1);
        return Math.min(p1, p2);
    }

    public static int dp(List<List<Integer>> triangle) {
        int M = triangle.size();
        int N = triangle.get(M - 1)
                        .size();

        int[][] dp = new int[M][N];

        for (int i = 0; i < N; i++) {
            dp[M - 1][i] = triangle.get(M - 1)
                                   .get(i);
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i)
                                        .size(); j++) {
                dp[i][j] = triangle.get(i)
                                   .get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
