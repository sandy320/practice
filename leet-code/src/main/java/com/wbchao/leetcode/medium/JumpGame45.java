package com.wbchao.leetcode.medium;

public class JumpGame45 {

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        return dp(nums);
    }

    public static int dp(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];

        for (int i = N - 2; i >= 0; i--) {
            dp[i] = dp[i + 1];
            for (int j = i + 1; j <= Math.min(i + nums[i], N - 1); j++) {
                dp[i] = Math.min(dp[i], dp[j]);
            }
            dp[i]++;
        }
        return dp[0];
    }
}
