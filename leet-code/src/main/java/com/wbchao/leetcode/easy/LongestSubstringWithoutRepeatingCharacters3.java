package com.wbchao.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int N = str.length;
        if (N == 0 || N == 1) {
            return N;
        }

        // 每个字符上次出现的位置，初始值都为-1
        int[] lastPos = new int[256];
        for (int i = 0; i < 256; i++) {
            lastPos[i] = -1;
        }
        int ans = 1;
        int pre = 1; //上一个位置结尾不重复有多长
        lastPos[str[0]] = 0;
        for (int i = 1; i < N; i++) {
            int p1 = i - lastPos[str[i]];
            int p2 = pre + 1;
            int cur = Math.min(p1, p2);
            pre = cur;
            ans = Math.max(ans, cur);
            lastPos[str[i]] = i;
        }
        return ans;
    }
}
