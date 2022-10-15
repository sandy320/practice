package com.wbchao.leetcode;

public class MaximumAscendingSubarraySum1800 {

    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
                ans = Math.max(ans, cur);
            } else {
                cur = nums[i];
            }
        }
        return ans;
    }
}
