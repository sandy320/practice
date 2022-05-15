package com.wbchao.leetcode.offer;

public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            if (nums[L] + nums[R] == target) {
                return new int[]{nums[L], nums[R]};
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                R--;
            }
        }
        return null;
    }
}
