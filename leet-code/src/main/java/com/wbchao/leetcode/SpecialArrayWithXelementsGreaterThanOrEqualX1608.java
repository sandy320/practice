package com.wbchao.leetcode;

import java.util.Arrays;

public class SpecialArrayWithXelementsGreaterThanOrEqualX1608 {

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 6, 4, 9};
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        if (nums[0] >= N) {
            return N;
        }
        for (int i = 1; i < N; i++) {
            int count = N - i;
            if (nums[i - 1] < count && nums[i] >= count) {
                return count;
            }
        }
        return -1;
    }
}
