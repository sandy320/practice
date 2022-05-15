package com.wbchao.leetcode.offer;

public class Offer21 {

    public int[] exchange(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            if ((nums[L] & 1) == 0) {
                swap(nums, L, R--);
            } else {
                L++;
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
