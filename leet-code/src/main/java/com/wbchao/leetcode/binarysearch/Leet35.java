package com.wbchao.leetcode.binarysearch;

public class Leet35 {

    public int searchInsert(int[] nums, int target) {
        return process(nums, target, 0, nums.length - 1);
    }

    public static int process(int[] nums, int target, int L, int R) {
        if (L > R) {
            return L;
        }
        int mid = L + (R - L) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return process(nums, target, mid + 1, R);
        } else {
            return process(nums, target, L, mid - 1);
        }
    }
}
