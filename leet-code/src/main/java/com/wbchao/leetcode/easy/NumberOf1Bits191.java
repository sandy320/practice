package com.wbchao.leetcode.easy;

public class NumberOf1Bits191 {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            int firstOne = n & (~n + 1);
            n = n - firstOne;
            ans++;
        }
        return ans;
    }
}
