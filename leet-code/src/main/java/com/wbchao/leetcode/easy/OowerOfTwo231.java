package com.wbchao.leetcode.easy;

public class OowerOfTwo231 {

    public boolean isPowerOfTwo(int n) {

        return n > 0 && n == (n & (~n + 1));
    }
}
