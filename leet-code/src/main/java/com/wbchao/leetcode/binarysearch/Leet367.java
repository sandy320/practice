package com.wbchao.leetcode.binarysearch;

public class Leet367 {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147395600));
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1 || num == 4) {
            return true;
        }
        int L = 0;
        int R = (1 << 16);
        return process(L, R, num);
    }

    public static boolean process(long L, long R, int num) {
        if (L == R) {
            return L * L == num;
        }
        long mid = L + (R - L) / 2;
        long val = mid * mid;
        if (val == num) {
            return true;
        } else if (val < num) {
            return process(mid + 1, R, num);
        } else {
            return process(L, mid, num);
        }
    }
}
