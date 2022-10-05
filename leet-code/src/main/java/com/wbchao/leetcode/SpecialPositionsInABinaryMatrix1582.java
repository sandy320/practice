package com.wbchao.leetcode;

public class SpecialPositionsInABinaryMatrix1582 {

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int M = mat.length;
        int N = mat[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(numSpecial(mat));
    }

    public static int numSpecial(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[] colSum = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                colSum[i] += mat[j][i];
            }
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            int rowIndex = -1;
            for (int j = 0; j < N; j++) {
                if (rowIndex == -1 && mat[i][j] == 1) {
                    rowIndex = j;
                } else if (rowIndex != -1 && mat[i][j] == 1) {
                    rowIndex = -1;
                    break;
                }
            }
            if (rowIndex != -1 && colSum[rowIndex] == 1) {
                ans++;
            }
        }
        return ans;
    }
}
