package com.wbchao.leetcode.easy;

public class BinarySearch704 {

    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }
}
