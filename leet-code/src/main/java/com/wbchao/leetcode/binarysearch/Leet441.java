package com.wbchao.leetcode.binarysearch;

public class Leet441 {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }

    public static int arrangeCoins(int n) {
        if (n < 3) {
            return 1;
        }
        int L = 1;
        int R = n;
        return process(n, L, R);
    }

    public static int process(int n, int L, int R) {
        if (L == R) {
            return L == n ? L : L - 1;
        }
        int mid = L + (R - L) / 2;
        long cur = (long) mid * ((long) mid + 1) / 2;
        if (cur == n) {
            return mid;
        } else if (cur < n) {
            return process(n, mid + 1, R);
        } else {
            return process(n, L, mid);
        }
    }
}
