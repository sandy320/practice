package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErecTheFence587 {

    public static void main(String[] args) {
      //  int[][] trees = new int[][]{{3, 7}, {6, 8}, {7, 8}, {11, 10}, {4, 3}, {8, 5}, {7, 13}, {4, 13}};
        int[][] trees = new int[][]{{0,0},{0,100},{100,100},{100,0},{50,50}};
        int[][] ans = outerTrees(trees);
    }

    public static int[][] outerTrees(int[][] points) {
        int n = points.length;
        int s = 0;
        int[][] stack = new int[n << 1][];
        // x小的排前面，x一样的，y小的排前面
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            while (s > 1 && cross(stack[s - 2], stack[s - 1], points[i]) > 0) {
                s--;
            }
            stack[s++] = points[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            while (s > 1 && cross(stack[s - 2], stack[s - 1], points[i]) > 0) {
                s--;
            }
            stack[s++] = points[i];
        }
        // 去重返回
        Arrays.sort(stack, 0, s, (a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
        n = 1;
        for (int i = 1; i < s; i++) {
            // 如果i点，x和y，与i-1点，x和y都一样
            // i点与i-1点，在同一个位置，此时，i点不保留
            if (stack[i][0] != stack[i - 1][0] || stack[i][1] != stack[i - 1][1]) {
                stack[n++] = stack[i];
            }
        }
        return Arrays.copyOf(stack, n);
    }

    // 叉乘的实现
    // 假设有a、b、c三个点，并且给出每个点的(x,y)位置
    // 从a到c的向量，在从a到b的向量的哪一侧？
    // 如果a到c的向量，在从a到b的向量右侧，返回正数
    // 如果a到c的向量，在从a到b的向量左侧，返回负数
    // 如果a到c的向量，和从a到b的向量重合，返回0
    public static int cross(int[] a, int[] b, int[] c) {
        return (b[1] - a[1]) * (c[0] - b[0]) - (b[0] - a[0]) * (c[1] - b[1]);
    }

}
