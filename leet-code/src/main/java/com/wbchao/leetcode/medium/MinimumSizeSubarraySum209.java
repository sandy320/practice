package com.wbchao.leetcode.medium;

public class MinimumSizeSubarraySum209 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int R = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (L <= R && R <= nums.length) {
            if (sum >= target) {
                ans = Math.min(ans, R - L);
                sum -= nums[L++];
            } else {
                if (R == nums.length) {
                    break;
                }
                sum += nums[R++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
