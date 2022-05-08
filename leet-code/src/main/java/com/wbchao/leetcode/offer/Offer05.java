package com.wbchao.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer05 {

    public static void main(String[] args) {
        String s = "who  are  you";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        List<Integer> zeroIndexs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                zeroIndexs.add(i);
            }
        }
        int begin = 0;
        String ans = "";
        for (int zeroIndex : zeroIndexs) {
            ans = ans + s.substring(begin, zeroIndex) + "%20";
            begin = zeroIndex + 1;
        }
        ans = ans + s.substring(begin);
        return ans;
    }

    public static String replaceSpace2(String s) {
        int zeroCount = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                zeroCount++;
            }
        }

        char[] newStr = new char[str.length + 2 * zeroCount];
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                newStr[j++] = '%';
                newStr[j++] = '2';
                newStr[j++] = '0';
            } else {
                newStr[j++] = str[i];
            }
        }
        return new String(newStr);
    }
}
