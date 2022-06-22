package com.wbchao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2nArray961 {

    public int repeatedNTimes(int[] nums) {
        int N = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return nums[N];
    }
}
