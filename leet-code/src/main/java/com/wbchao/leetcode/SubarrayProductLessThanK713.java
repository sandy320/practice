package com.wbchao.leetcode;

public class SubarrayProductLessThanK713 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(numSubarrayProductLessThanK(nums, 1));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int N = nums.length;
        int L = 0;
        int R = 0;
        int cur = nums[0];
        int ans = 0;
        while (R < N) {
            if (cur < k) {
                ans += R - L + 1;
                R++;
                if (R == N) {
                    break;
                }
                cur = cur * nums[R];
            } else {
                cur = cur / nums[L++];
                if (L == N) {
                    break;
                }
            }
        }
        return ans;

    }
}
