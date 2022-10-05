package com.wbchao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        char[] str = s.toCharArray();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (!map.containsKey(str[i])) {
                map.put(str[i], i);
            } else {
                ans = Math.max(ans, i - map.get(str[i]));
                map.put(str[i], i);
            }
        }
        return ans - 1;
    }
}
