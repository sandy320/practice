package com.wbchao.leetcode.easy;

public class ReverseString344 {

    public void reverseString(char[] s) {
        int L = 0;
        int R = s.length - 1;
        while (L < R) {
            char tmp = s[L];
            s[L++] = s[R];
            s[R--] = tmp;
        }
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (String str : s.split(" ")) {
            char[] chars = str.toCharArray();
            reverseString(chars);
            sb.append(" ")
              .append(new String(chars));
        }
        return sb.substring(1);
    }
}
