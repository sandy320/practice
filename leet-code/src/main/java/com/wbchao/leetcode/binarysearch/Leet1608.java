package com.wbchao.leetcode.binarysearch;

public class Leet1608 {

    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0] >= 1 ? 1 : -1;
        }
        int L = 0;
        int R = N;
        int count = 0;
        int mid = 0;
        while (L <= R) {
            mid = L + (R - L) / 2;
            count = 0;
            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }
            if (count == mid) {
                return mid;
            } else if (count < mid) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return mid == count ? mid : -1;
    }
}
