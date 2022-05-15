package com.wbchao.leetcode.medium;

public class SearchA2dMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int L = 0;
        int R = M * N - 1;

        while (L < R) {
            int mid = L + (R - L) / 2;
            if (getValue(matrix, mid) == target) {
                return true;
            } else if (getValue(matrix, mid) < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return getValue(matrix, L) == target ? true : false;
    }

    public static int getValue(int[][] matrix, int index) {
        int N = matrix[0].length;

        int i = index / N;
        int j = index % N;
        return matrix[i][j];
    }
}
