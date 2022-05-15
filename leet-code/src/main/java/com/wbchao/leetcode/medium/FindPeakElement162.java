package com.wbchao.leetcode.medium;

public class FindPeakElement162 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {

        int N = nums.length;
        int L = 0;
        int R = N - 1;

        if (N == 1) {
            return 0;
        }

        if (nums[1] < nums[0]) {
            return 0;
        }

        if (nums[N - 1] > nums[N - 2]) {
            return N - 1;
        }

        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return L;
    }
}
