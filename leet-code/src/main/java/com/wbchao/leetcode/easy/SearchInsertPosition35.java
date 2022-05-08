package com.wbchao.leetcode.easy;

public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
        int R = nums.length;
        int L = 0;
        while (L < R) {
            int mid = L + (R - L) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return L;
    }
}
