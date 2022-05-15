package com.wbchao.leetcode.medium;

public class FindMinimumInRotatedSortedArray153 {

    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {

        int N = nums.length;
        int L = 0;
        int R = N - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] <= nums[L] && nums[mid] < nums[R]) {
                R = mid;
            } else if (nums[mid] >= nums[L] && nums[mid] > nums[R]) {
                L = mid + 1;
            } else {
                return nums[L];
            }
        }
        return nums[L];
    }
}
