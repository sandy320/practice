package com.wbchao.leetcode.medium;

public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;

        int ans = 0;
        while (L < R) {
            ans = Math.max(ans, (R - L) * Math.min(height[L], height[R]));
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return ans;
    }
}
