package com.wbchao.leetcode.binarysearch;

public class Leet69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (x < 4) {
            return 1;
        }
        int L = 0;
        int R = (1 << 16);
        return process(x, L, R);
    }

    public static int process(int x, int L, int R) {
        if (L == R) {
            long sqrt = (long) L * (long) L;
            return sqrt > x ? L - 1 : L;
        }
        int mid = L + (R - L) / 2;
        long sqrt = (long) mid * (long) mid;
        if (sqrt == x) {
            return mid;
        } else if (sqrt < x) {
            return process(x, mid + 1, R);
        } else {
            return process(x, L, mid);
        }
    }
}
