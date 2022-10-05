package com.wbchao.leetcode;

import java.util.Arrays;

public class WiggleSortii324 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3};
        wiggleSort(nums);
        for (int num : nums) {
            System.out.printf(" " + num);
        }
    }

    public static void wiggleSort(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        int[] help = new int[N];

        int L = (N -1)/ 2;
        int R = N - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                help[i] = nums[L--];
            } else {
                help[i] = nums[R--];

            }
        }
        for (int i = 0; i < N; i++) {
            nums[i] = help[i];
        }
    }
}
