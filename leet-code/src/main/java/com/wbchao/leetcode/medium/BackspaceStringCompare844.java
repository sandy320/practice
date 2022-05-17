package com.wbchao.leetcode.medium;

import java.util.Stack;

public class BackspaceStringCompare844 {

    public boolean backspaceCompare(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        return convert(sChar).equals(convert(tChar));
    }

    public static String convert(char[] chars) {
        char[] stack = new char[chars.length];
        int size = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#') {
                stack[size++] = chars[i];
            } else {
                if (size > 0) {
                    size--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}
