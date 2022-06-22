package com.wbchao.leetcode.medium;

public class ArithmeticSlices413 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 9, 10};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int N = nums.length;
        //如果构不成等差数列，返回0
        if (N < 3) {
            return 0;
        }
        //其中dp[i]表示以nums[i]为等差数列最后一个元素的等差数列个数
        int[] dp = new int[N];
        //等差数列的个数
        int count = 0;
        //等差数列的差值
        int diff = nums[1] - nums[0];
        for (int i = 2; i < N; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                //如果当前数字和前面的可以构成等差数列，
                //就更新dp和count的值
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            } else {
                //如果不能和前面的构成等差数列，要重新计算diff
                diff = nums[i] - nums[i - 1];
            }
        }
        return count;
    }
}
