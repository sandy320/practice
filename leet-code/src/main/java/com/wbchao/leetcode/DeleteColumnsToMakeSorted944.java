package com.wbchao.leetcode;

public class DeleteColumnsToMakeSorted944 {

    public int minDeletionSize(String[] strs) {
        int M = strs.length;
        int N = strs[0].length();

        char[][] grid = new char[M][N];

        for (int i = 0; i < strs.length; i++) {
            grid[i] = strs[i].toCharArray();
        }

        int ans = 0;
        for (int col = 0; col < N; col++) {
            for (int row = 1; row < M; row++) {
                if (grid[row][col] < grid[row - 1][col]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
