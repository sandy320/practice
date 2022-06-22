package com.wbchao.leetcode.medium;

import javax.security.auth.login.CredentialNotFoundException;

public class HouseRobber213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }

        if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[N];
        //选0，不选N-1,答案为dp[N-2]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int ans = dp[N - 2];
        //不选0
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(ans, dp[N - 1]);
    }
}
