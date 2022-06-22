package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern.toCharArray())) {
                ans.add(word);
            }
        }
        return ans;
    }

    public static boolean match(String word, char[] pattern) {
        int[] map = new int[26];
        boolean[] used = new boolean[26];
        char[] str = word.toCharArray();
        for (int i = 0; i < pattern.length; i++) {
            if (map[str[i] - 'a'] == 0) {
                if (!used[pattern[i] - 'a']) {
                    map[str[i] - 'a'] = pattern[i];
                    used[pattern[i] - 'a'] = true;
                } else {
                    return false;
                }
            } else {
                if (map[str[i] - 'a'] != pattern[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
