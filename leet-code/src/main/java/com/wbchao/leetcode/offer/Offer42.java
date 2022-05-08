package com.wbchao.leetcode.offer;

public class Offer42 {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int N = nums.length;
        int[] sum = new int[N];
        sum[0] = nums[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int min = Math.min(0, sum[0]);
        int ans = sum[0];
        for (int i = 1; i < N; i++) {
            ans = Math.max(ans, sum[i] - min);
            min = Math.min(min, sum[i]);
        }
        return ans;
    }

    public static int dp(int[] nums) {
        int pre = nums[0];
        int ans = pre;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (pre > 0) {
                cur = pre + nums[i];
            }
            ans = Math.max(ans, cur);
            pre = cur;
        }
        return ans;
    }
}
