package com.wbchao.leetcode.easy;

public class FirstBadVersion278 {

    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int L = 0;
        int R = n;
        int mid = 0;
        while (L < R) {
            mid = L + ((L - R) >> 1);
            if (isBadVersion(mid)) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return mid;
    }
}
