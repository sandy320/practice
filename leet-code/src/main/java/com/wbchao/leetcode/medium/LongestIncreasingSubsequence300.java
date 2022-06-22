package com.wbchao.leetcode.medium;

public class LongestIncreasingSubsequence300 {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        } int ans = 1;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
