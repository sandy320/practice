package com.wbchao.leetcode;

public class LongestArithmeticSubsequence1027 {

    public int longestArithSeqLength(int[] nums) {
        int M = nums.length;
        int N = 1001;
        int[][] dp = new int[M][N];
        int ans = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = dp[j][d] + 1;
                ans = Math.max(ans, dp[i][d]);
            }
        }
        return ans + 1;
    }

}
