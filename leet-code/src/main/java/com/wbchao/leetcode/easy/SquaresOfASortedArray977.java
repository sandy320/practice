package com.wbchao.leetcode.easy;

public class SquaresOfASortedArray977 {

    public static void main(String[] args) {
        int[] nums = new int[]{-11, 2, 3};
        int[] ans = sortedSquares(nums);
        for (int num : ans) {
            System.out.printf(" " + num);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int L = 0;
        int R = N - 1;
        int[] ans = new int[N];
        int index = N - 1;
        while (L <= R) {
            if (nums[L] * nums[L] > nums[R] * nums[R]) {
                ans[index--] = nums[L] * nums[L];
                L++;
            } else {
                ans[index--] = nums[R] * nums[R];
                R--;
            }
        }
        return ans;
    }
}
