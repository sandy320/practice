package com.wbchao.leetcode.offer;

public class Offer66 {

    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        int tmp = 1;
        for (int i = 0; i < a.length; i++) {
            ans[i] = tmp;
            tmp *= a[i];
        }
        tmp = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            ans[i] *= tmp;
            tmp *= a[i];
        }
        return ans;
    }
}
