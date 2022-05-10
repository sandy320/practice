package com.wbchao.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LletterCasePermutation784 {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a4c"));
    }

    public static List<String> letterCasePermutation(String s) {
        char[] str = s.toCharArray();
        List<String> ans = new ArrayList<>();
        dfs(str, 0, ans);
        return ans;
    }

    public static void dfs(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(new String(str));
            return;
        }

        dfs(str, index + 1, ans);
        if (Character.isLetter(str[index])) {
            str[index] ^= 32;
            dfs(str, index + 1, ans);
        }
    }
}
