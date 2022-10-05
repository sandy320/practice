package com.wbchao.leetcode.binarysearch;

import java.util.Arrays;

public class Leet1385 {

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int num : arr1) {
            int min = num - d;
            int max = num + d;
            if (!process(arr2, min, max, 0, arr2.length - 1)) {
                ans++;
            }
        }
        return ans;
    }

    public static boolean process(int[] arr, int min, int max, int L, int R) {
        if (L == R) {
            return arr[L] >= min && arr[L] <= max;
        }

        int mid = L + (R - L) / 2;
        if (arr[mid] >= min && arr[mid] <= max) {
            return true;
        } else if (arr[mid] < min) {
            return process(arr, min, max, mid + 1, R);
        } else {
            return process(arr, min, max, L, mid);
        }
    }
}
