package com.wbchao.leetcode.easy;

public class RotateArray189 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate2(nums, 3);
        for (int num : nums) {
            System.out.printf(" " + num);
        }
    }

    public static void rotate(int[] nums, int k) {
        int N = nums.length;
        int[] help = new int[2 * N];
        k = k % N;
        for (int i = 0; i < N; i++) {
            help[i] = nums[i];
            help[N + i] = nums[i];
        }
        int index = 0;
        for (int i = N - k; i < 2 * N - k; i++) {
            nums[index++] = help[i];
        }
    }

    public static void reverse(int[] nums, int L, int R) {
        while (L < R) {
            int tmp = nums[L];
            nums[L++] = nums[R];
            nums[R--] = tmp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        reverse(nums, 0, N - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, N - 1);
    }

}
