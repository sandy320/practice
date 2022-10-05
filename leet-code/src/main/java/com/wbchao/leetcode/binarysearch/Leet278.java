package com.wbchao.leetcode.binarysearch;

public class Leet278 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        return process(0, n);
    }

    public static int process(int L, int R) {
        if (L >= R) {
            return L;
        }

        int mid = L + (R - L) / 2;
        if (isBadVersion(mid)) {
            return process(L, mid);
        } else {
            return process(mid + 1, R);
        }
    }

    static boolean isBadVersion(int version) {
        return version == 4;
    }
}
