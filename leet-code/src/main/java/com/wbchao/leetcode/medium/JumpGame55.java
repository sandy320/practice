package com.wbchao.leetcode.medium;

public class JumpGame55 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        return process(nums, 0);
    }

    public static boolean process(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        boolean ans = false;
        for (int i = 1; i <= nums[index]; i++) {
            ans = process(nums, index + i);
            if (ans) {
                break;
            }
        }
        return ans;
    }

    public static boolean dp(int[] nums) {
        int N = nums.length;
        boolean[] dp = new boolean[N];
        dp[N - 1] = true;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j <= Math.min(i + nums[i], N - 1); j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
