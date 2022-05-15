package com.wbchao.leetcode.offer;

import java.util.Arrays;

public class Offer61 {

    public boolean isStraight(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        int kingCount = 0;
        for (int i = 0; i < N - 1; i++) {
            if (nums[i] == 0) {
                kingCount++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }

        }
        return nums[N - 1] - nums[kingCount] < N;
    }
}
