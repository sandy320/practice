package com.wbchao.leetcode.binarysearch;

import java.util.regex.Pattern;

public class Leet167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int N = numbers.length;
        for (int i = 0; i < N - 1; i++) {
            int j = find(numbers, target - numbers[i], i + 1, N - 1);
            if (j != -1) {
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }
        }
        return ans;
    }

    public static int find(int[] numbers, int target, int L, int R) {
        if (L == R) {
            return numbers[L] == target ? L : -1;
        }

        int mid = L + (R - L) / 2;
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] < target) {
            return find(numbers, target, mid + 1, R);
        } else {
            return find(numbers, target, L, mid);
        }
    }
}
