package com.wbchao.leetcode.binarysearch;

public class Leet34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = process(nums, target - 1, 0, nums.length - 1);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = process(nums, target, 0, nums.length - 1);
        if (left == right) {
            return new int[]{-1, -1};
        }
        if (right == -1) {
            right = nums.length - 1;
        } else {
            right = right - 1;
        }
        return new int[]{left, right};
    }

    //大于target的最左位置
    public static int process(int[] nums, int target, int L, int R) {
        if (L == R) {
            return nums[L] > target ? L : -1;
        }
        int mid = L + (R - L) / 2;
        if (nums[mid] <= target) {
            return process(nums, target, mid + 1, R);
        } else {
            return process(nums, target, L, mid);
        }
    }
}
