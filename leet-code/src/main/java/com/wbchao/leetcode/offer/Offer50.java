package com.wbchao.leetcode.offer;

public class Offer50 {

    public char firstUniqChar(String s) {
        char[] str = s.toCharArray();
        char[] map = new char[26];
        for (int i = 0; i < str.length; i++) {
            map[str[i] - 'a']++;
        }
        for (int i = 0; i < str.length; i++) {
            if (map[str[i] - 'a'] == 1) {
                return str[i];
            }
        }
        return ' ';
    }
}
