package com.wbchao.leetcode;

public class RotatedDigits788 {

    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            boolean ok = false;
            int x = i;
            while (x != 0) {
                int d = x % 10;
                x /= 10;
                if (check[d] == 1) {
                    ok = true;
                } else if (check[d] == -1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ++ans;
            }
        }
        return ans;
    }

}
