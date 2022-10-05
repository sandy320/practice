package com.wbchao.leetcode;

public class ArrayNesting565 {

    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums) {
        int N = nums.length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int j = i;
            int cur = 0;
            while (nums[j] != -1) {
                cur++;
                int pre = j;
                j = nums[j];
                nums[pre] = -1;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
