package com.wbchao.leetcode.offer;

public class Offer17 {

    public int[] printNumbers(int n) {
        int len = (int) (Math.pow(10, n) - 1);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
