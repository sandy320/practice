package com.wbchao.leetcode;

public class LongestUncommonSubsequence522 {

    public int findLUSlength(String[] strs) {
        int N = strs.length;
        boolean flag = false;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && isSub(strs[i], strs[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }


    public static boolean isSub(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int i = 0;
        int j = 0;
        while (i < str1.length && j < str2.length) {
            if (str1[i] == str2[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == str1.length;
    }
}
