package com.wbchao.leetcode;

import java.util.Random;

public class RandomPointInNonOverlappingRectangles497 {

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        Solution s = new Solution(rects);
        s.pick();
    }

    public static class Solution {

        int[][] r;
        int[] sum;
        Random random;

        public Solution(int[][] rects) {
            r = rects;
            random = new Random();
            int curSum = 0;
            int total = 0;
            sum = new int[rects.length + 1];
            for (int i = 1; i <= rects.length; i++) {
                sum[i] = sum[i - 1] + (rects[i - 1][3] - rects[i - 1][1] + 1) * (rects[i - 1][2] - rects[i - 1][0] + 1);
            }
        }

        public int[] pick() {
            int N = sum.length;
            int pickSum = random.nextInt(sum[N - 1]) + 1;
            int L = 0;
            int R = N - 1;
            int pickIndex = 0;
            while (L <= R) {
                int mid = L + (R - L) / 2;
                if (sum[mid] > pickSum) {
                    R = mid - 1;
                } else {
                    pickIndex = mid;
                    L = mid + 1;
                }
            }
            int a = r[pickIndex][0];
            int b = r[pickIndex][1];
            int x = r[pickIndex][2];
            int y = r[pickIndex][3];

            return new int[]{a + random.nextInt(x - a + 1), b + random.nextInt(y - b + 1)};
        }
    }
}
