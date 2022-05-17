package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections986 {

    public static void main(String[] args) {
        int[][] first = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] second = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ans = intervalIntersection(first, second);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        int N1 = firstList.length;
        int N2 = secondList.length;

        while (p1 < N1 && p2 < N2) {
            int[] range1 = firstList[p1];
            int[] range2 = secondList[p2];

            int L = Math.max(range1[0], range2[0]);
            int R = Math.min(range1[1], range2[1]);

            if (L <= R) {
                ans.add(new int[]{L, R});
            }

            if (range1[1] < range2[1]) {
                p1++;
            } else if (range1[1] > range2[1]) {
                p2++;
            } else {
                p1++;
                p2++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
