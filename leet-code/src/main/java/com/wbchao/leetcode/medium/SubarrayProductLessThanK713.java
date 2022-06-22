package com.wbchao.leetcode.medium;

public class SubarrayProductLessThanK713 {

    public static void main(String[] args) {
        int[] nums = {100, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ans = 0;
        if (k <= 1) {
            return 0;
        }
        for (int i = 0, j = 0, cur = 1; i < n; i++) {
            cur *= nums[i];
            while (cur >= k) {
                cur /= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }

}
