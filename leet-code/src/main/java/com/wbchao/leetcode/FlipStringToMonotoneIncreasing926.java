package com.wbchao.leetcode;

public class FlipStringToMonotoneIncreasing926 {

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
    }

    public static int minFlipsMonoIncr(String s) {
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][2];

        //第一个字符如果是0的话，调整为1的代价是1
        if (str[0] == '0') {
            dp[0][1] = 1;
        } else {
            dp[0][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            // 分2种情况讨论，
            // i-1如果是0
            dp[i][0] = dp[i - 1][0] + (str[i] == '1' ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (str[i] == '1' ? 0 : 1);

        }
        return Math.min(dp[N - 1][1], dp[N - 1][0]);
    }

}
