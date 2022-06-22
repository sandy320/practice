package com.wbchao.leetcode.offer;

public class Offer16 {

    public static void main(String[] args) {
        System.out.println(myPow(3, 4));
    }

    public static double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        long b = n;
        if (b < 0) {
            b= -b;
            x = 1/x;
        }
        double ans = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                ans = ans * x;
            }
            x *= x;
            b = b >> 1;
        }
        return ans ;
    }
}
