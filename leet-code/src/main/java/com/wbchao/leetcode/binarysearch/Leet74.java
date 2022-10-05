package com.wbchao.leetcode.binarysearch;

public class Leet74 {

    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int i = M - 1;
        int j = 0;
        while (i >= 0 && j < N) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
