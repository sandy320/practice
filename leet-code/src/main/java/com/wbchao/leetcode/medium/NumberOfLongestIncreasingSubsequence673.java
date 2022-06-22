package com.wbchao.leetcode.medium;

public class NumberOfLongestIncreasingSubsequence673 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int[] count = new int[N];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            count[i] = 1;
            dp[i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1== dp[i]) {
                        count[i] += count[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
        }
        int max = 1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }
}
