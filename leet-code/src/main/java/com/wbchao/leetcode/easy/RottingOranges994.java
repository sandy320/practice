package com.wbchao.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int count1 = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count1++;
                }
            }
        }

        if (queue.isEmpty()) {
            return count1 > 0 ? -1 : 0;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.add(new int[]{i - 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.add(new int[]{i, j - 1});
                }
                if (i + 1 < M && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    queue.add(new int[]{i + 1, j});
                }
                if (j + 1 < N && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    queue.add(new int[]{i, j + 1});
                }
            }
            ans++;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans - 1;
    }
}
