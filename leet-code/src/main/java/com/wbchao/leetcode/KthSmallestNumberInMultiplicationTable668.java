package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestNumberInMultiplicationTable668 {

    public static void main(String[] args) {
        System.out.println(findKthNumber(45, 12, 473));
        int[] ans1 = near(2, 3, 6);
        int[] ans2 = near1(2, 3, 5, 6);
        System.out.println(ans1[0] + " " + ans1[1]);
        System.out.println(ans2[0] + " " + ans2[1]);
    }

    public static int findKthNumber(int m, int n, int k) {
        int min = 1;
        int max = m * n;
        int ans = 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int[] info = near(m, n, mid);
            if (info[0] < k) {
                min = mid + 1;
            } else {
                ans = info[1];
                max = mid - 1;
            }
        }
        return ans;
    }

    public static int[] near1(int m, int n, int target, int num) {
        int[] all = new int[m * n + 1];
        int index = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                all[index++] = i * j;
            }
        }
        Arrays.sort(all);
        System.out.println(all[num]);
        int L = 1;
        int R = m * n;
        index = -1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (all[mid] < target) {
                L = mid + 1;
            } else {
                index = mid;
                R = mid - 1;
            }
        }
        return new int[]{index, all[index]};
    }

    // 返回<=target的有几个
    public static int[] near(int m, int n, int target) {
        int row = 1;
        int col = n;
        int ans = 0;
        int near = 0;

        while (row <= m && col >= 1) {
            if (target >= row * col) {
                near = Math.max(near, row * col);
                row++;
                ans += col;
            } else {
                col--;
            }
        }
        return new int[]{ans, near};
    }
}
