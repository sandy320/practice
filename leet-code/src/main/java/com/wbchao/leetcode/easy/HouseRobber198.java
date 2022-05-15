package com.wbchao.leetcode.easy;

public class HouseRobber198 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(dp(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return process(nums, 0, false);
    }

    //来到index位置，往后能获得最多的钱
    //pre ture表示前一个偷了
    public static int process(int[] nums, int index, boolean pre) {
        if (index == nums.length) {
            return 0;
        }

        //不偷当前
        int ans = process(nums, index + 1, false);

        if (!pre) {
            ans = Math.max(ans, nums[index] + process(nums, index + 1, true));
        }
        return ans;
    }

    public static int dp(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }

        int[] dpTrue = new int[N];
        int[] dpFalse = new int[N];

        dpTrue[N - 1] = 0;
        dpFalse[N - 1] = nums[N-1];

        for (int i = N - 2; i >= 0; i--) {
            dpTrue[i] = dpFalse[i + 1];
            dpFalse[i] = Math.max(dpTrue[i], nums[i] + dpTrue[i + 1]);
        }
        return dpFalse[0];
    }

}
