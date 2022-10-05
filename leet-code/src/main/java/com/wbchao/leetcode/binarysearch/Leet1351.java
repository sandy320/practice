package com.wbchao.leetcode.binarysearch;

public class Leet1351 {

    public int countNegatives(int[][] grid) {
        int ans = 0;
        int M = grid.length;
        int N = grid[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] < 0) {
                    ans += N - j;
                    break;
                }
            }
        }
        return ans;
    }
}
