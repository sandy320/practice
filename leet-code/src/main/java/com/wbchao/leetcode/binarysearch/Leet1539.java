package com.wbchao.leetcode.binarysearch;

public class Leet1539 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 2;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {

        if (arr[0] > k) {
            return k;
        }

        int leftIndex = process(arr, k, 0, arr.length - 1);
        int gap = arr[leftIndex] - leftIndex - 1;
        return arr[leftIndex] + (k - gap);
    }

    public static int process(int[] arr, int k, int L, int R) {
        if (L == R) {
            return (arr[L] - L - 1) >= k ? L - 1 : L;
        }

        int mid = L + (R - L) / 2;
        int gap = arr[mid] - mid - 1;
        if (gap >= k) {
            return process(arr, k, L, mid);
        } else {
            return process(arr, k, mid + 1, R);
        }
    }
}
