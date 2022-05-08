package com.wbchao.leetcode;

public class SmallestRange908 {

    public int smallestRangeI(int[] nums, int k) {
        int N = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max - min <= k * 2) {
            return 0;
        } else {
            return max - k - (min + k);
        }
    }
}
