package com.wbchao.leetcode.easy;

public class MoveZeroes283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        while (R >= 0 && nums[R] == 0) {
            R--;
        }
        while (L < R) {
            if (nums[L] == 0) {
                for (int i = L; i < R; i++) {
                    int tmp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmp;
                }
                R--;
            } else {
                L++;
            }
        }
    }
}
