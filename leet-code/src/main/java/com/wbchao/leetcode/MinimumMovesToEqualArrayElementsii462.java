package com.wbchao.leetcode;

import java.util.Arrays;
import java.util.Random;

public class MinimumMovesToEqualArrayElementsii462 {

    public int minMoves2(int[] nums) {
        int N = nums.length;
        int k = N / 2;
        Random r = new Random();
        int target = r.nextInt(N);
        Arrays.sort(nums);
        int mid = nums[k];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum+=Math.abs(nums[i] - mid);
        }
        return sum;
    }
}
