package com.wbchao.leetcode;

import java.util.Arrays;

public class MinimumAddToMakeParenthesesValid921 {

    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        return process(str, 0, N - 1, dp);

    }

    public static int minAddToMakeValid2(String s) {
        int leftCnt = 0;
        int rightCnt = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCnt++;
            } else {
                rightCnt++;
            }
            if (rightCnt > leftCnt) {
                ans++;
                leftCnt++;
            }
        }
        return ans + leftCnt - rightCnt;
    }

    public static int process(char[] s, int i, int j, int[][] dp) {
        if (i == j) {
            return 1;
        }
        if (i == j - 1) {
            return s[i] == '(' && s[j] == ')' ? 0 : 2;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        //包含关系
        int p1 = 1 + process(s, i + 1, j, dp);
        int p2 = 1 + process(s, i, j - 1, dp);
        int p3 = Integer.MAX_VALUE;
        if (s[i] == '(' && s[j] == ')') {
            p3 = process(s, i + 1, j - 1, dp);
        }

        int ans = Math.min(p1, Math.min(p2, p3));

        //并列关系
        for (int split = i; split < j; split++) {
            int cur = process(s, i, split, dp) + process(s, split + 1, j, dp);
            ans = Math.min(cur, ans);
        }
        dp[i][j] = ans;
        return ans;
    }
}
