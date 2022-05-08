package com.wbchao.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix542 {

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] ans = updateMatrix(mat);
        int M = mat.length;
        int N = mat[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] ans = new int[M][N];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];

            if (i - 1 >= 0 && ans[i - 1][j] == -1) {
                ans[i - 1][j] = ans[i][j] + 1;
                queue.add(new int[]{i - 1, j});
            }
            if (j - 1 >= 0 && ans[i][j - 1] == -1) {
                ans[i][j - 1] = ans[i][j] + 1;
                queue.add(new int[]{i, j - 1});
            }
            if (i + 1 < M && ans[i + 1][j] == -1) {
                ans[i + 1][j] = ans[i][j] + 1;
                queue.add(new int[]{i + 1, j});
            }
            if (j + 1 < N && ans[i][j + 1] == -1) {
                ans[i][j + 1] = ans[i][j] + 1;
                queue.add(new int[]{i, j + 1});
            }
        }
        return ans;
    }
}
