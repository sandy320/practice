package com.wbchao.leetcode.binarysearch;

public class Leet153 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[L] <= nums[mid] && nums[mid] > nums[R]) {
                L = mid + 1;
            } else if (nums[L] > nums[mid] && nums[mid] < nums[R]) {
                R = mid;
            } else {
                return nums[L];
            }
        }
        return nums[L];
    }
}
