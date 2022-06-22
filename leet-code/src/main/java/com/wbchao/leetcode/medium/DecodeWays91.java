package com.wbchao.leetcode.medium;

public class DecodeWays91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("06"));
    }

    public static int numDecodings(String s) {
        char[] str = s.toCharArray();
        int N = s.length();
        return dp(s);
    }

    public static int dp(String s) {
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N];

        dp[N - 1] = str[N - 1] == '0' ? 0 : 1;
        for (int i = N - 2; i >= 0; i--) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else if (str[i] == '1' || (str[i] == '2' && str[i + 1] <= '6')) {
                int p1 = dp[i + 1];
                int p2 = i + 2 >= N ? 1 : dp[i + 2];
                dp[i] = p1 + p2;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static int process(char[] str, int index) {
        if (index == str.length - 1) {
            return str[index] == '0' ? 0 : 1;
        }
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }

        if (str[index] == '1' || (str[index] == '2' && str[index + 1] <= '6')) {
            int p1 = process(str, index + 1);
            int p2 = process(str, index + 2);
            return p1 + p2;
        } else {
            return process(str, index + 1);
        }
    }
}
