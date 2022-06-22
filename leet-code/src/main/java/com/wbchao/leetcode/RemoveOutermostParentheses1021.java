package com.wbchao.leetcode;

import java.util.Stack;

public class RemoveOutermostParentheses1021 {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }

    public static String removeOuterParentheses(String s) {
        char[] str = s.toCharArray();
        int[] stack = new int[s.length()];
        int size = 0;
        String ans = "";
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack[size++] = i;
            } else {
                int left = stack[--size];
                if (size == 0) {
                    ans += s.substring(left + 1, i);
                }
            }
        }
        return ans;
    }

}
