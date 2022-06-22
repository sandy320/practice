package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString438 {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] bill = new int[26];
        char[] pStr = p.toCharArray();
        for (int i = 0; i < pStr.length; i++) {
            bill[pStr[i] - 'a']++;
        }
        int all = pStr.length;
        char[] str = s.toCharArray();
        for (int i = 0; i < pStr.length; i++) {
            if (bill[str[i] - 'a'] > 0) {
                all--;
            }
            bill[str[i] - 'a']--;
        }
        int L = 0;
        int R = p.length();
        while (L < R && R < str.length) {
            if (all == 0) {
                ans.add(L);
            }
            if (bill[str[L] - 'a'] >= 0) {
                all++;
            }
            bill[str[L] - 'a']++;
            if (bill[str[R] - 'a'] > 0) {
                all--;
            }
            bill[str[R] - 'a']--;
            L++;
            R++;
        }
        if (all == 0) {
            ans.add(L);
        }
        return ans;
    }
}

