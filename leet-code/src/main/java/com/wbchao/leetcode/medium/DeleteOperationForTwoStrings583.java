package com.wbchao.leetcode.medium;

public class DeleteOperationForTwoStrings583 {

    public int minDistance(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int M = str1.length;
        int N = str2.length;

        int[][] dp = new int[M][N];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i - 1][0];
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < N; j++) {
            dp[0][j] = dp[0][j - 1];
            if (str1[0] == str2[j]) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        int same = dp[M - 1][N - 1];
        return M - same + N - same;
    }
}
