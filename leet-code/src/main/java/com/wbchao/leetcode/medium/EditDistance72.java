package com.wbchao.leetcode.medium;

public class EditDistance72 {

    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 1, 1, 1);
    }

    public static int minDistance(String w1, String w2, int dc, int ic, int rc) {
        char[] str1 = w1.toCharArray();
        char[] str2 = w2.toCharArray();

        int M = str1.length + 1;
        int N = str2.length + 1;

        int[][] dp = new int[M][N];

        for (int i = 1; i < M; i++) {
            dp[i][0] = i * ic;
        }

        for (int j = 1; j < N; j++) {
            dp[0][j] = j * dc;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
            }
        }
        return dp[M - 1][N - 1];
    }

}