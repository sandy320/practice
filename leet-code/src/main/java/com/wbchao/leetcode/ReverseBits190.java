package com.wbchao.leetcode;

public class ReverseBits190 {

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int last = n & 1;
            ans |= (last << (31 - i));
            n = n >> 1;
        }
        return ans;
    }
}
