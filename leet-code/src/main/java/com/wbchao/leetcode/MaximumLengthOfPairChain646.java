package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MaximumLengthOfPairChain646 {

    public static void main(String[] args) {
        int[][] pairs = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int N = pairs.length;
        int[] dp = new int[N];
        //dp[i]表示以list[i]开头往后最多能有多少个
        dp[N - 1] = 1;
        int ans = 1;
        for (int i = N - 2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (pairs[i][1] < pairs[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
