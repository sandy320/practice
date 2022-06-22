package com.wbchao.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer29 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("====================");
        spiralOrder(matrix);
    }

    public static int[] spiralOrder(int[][] matrix) {
        int M = matrix.length;
        if (M == 0) {
            return new int[]{};
        }
        int N = matrix[0].length;
        int x1 = 0;
        int y1 = 0;
        int x2 = M - 1;
        int y2 = N - 1;
        int[] ans = new int[M * N];
        while (x1 <= x2) {
            process(matrix, x1++, y1++, x2--, y2--, ans);
        }

        return ans;
    }

    public static void process(int[][] matrix, int x1, int y1, int x2, int y2, int[] ans) {
        if (x1 > x2 || y1 > y2) {
            return;
        }

        int index = ans.length - (y2 - y1 + 1) * (x2 - x1 + 1);
        for (int i = y1; i <= y2; i++) {
            ans[index++] = matrix[x1][i];
        }
        for (int i = x1 + 1; i <= x2; i++) {
            ans[index++] = matrix[i][y2];
        }
        for (int i = y2 - 1; i >= y1 && x1 != x2; i--) {
            ans[index++] = matrix[x2][i];
        }
        for (int i = x2 - 1; i > x1 && y1 != y2; i--) {
            ans[index++] = matrix[i][y1];
        }
    }
}
