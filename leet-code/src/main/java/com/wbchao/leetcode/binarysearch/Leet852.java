package com.wbchao.leetcode.binarysearch;

public class Leet852 {

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 2, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L > R) {
            return L;
        }
        int mid = L + (R - L) / 2;
        if (mid == L) {
            return arr[L] > arr[R] ? L : R;
        }
        if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
            return mid;
        } else if (arr[mid - 1] < arr[mid] && arr[mid + 1] > arr[mid]) {
            //上坡
            return process(arr, mid + 1, R);
        } else {
            return process(arr, L, mid - 1);
        }
    }
}
