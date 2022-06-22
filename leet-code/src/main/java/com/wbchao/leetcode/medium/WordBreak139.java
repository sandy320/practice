package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordBreak139 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        return process(s, wordDict, 0, dp);
    }

    public static boolean process(String s, List<String> wordDict, int index, int[] dp) {
        if (s.length() == index) {
            return true;
        }
        if (dp[index] != 0) {
            return dp[index] == 1;
        }
        for (String word : wordDict) {
            if (s.substring(index)
                 .startsWith(word)) {
                boolean res = process(s, wordDict, index + word.length(), dp);
                if (res) {
                    dp[index] = 1;
                    return true;
                }
            }
        }
        dp[index] = -1;
        return false;
    }
}
