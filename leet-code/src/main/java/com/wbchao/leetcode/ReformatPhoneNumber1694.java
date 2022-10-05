package com.wbchao.leetcode;

public class ReformatPhoneNumber1694 {

    public static void main(String[] args) {
        String number = "9964-";
        System.out.println(reformatNumber(number));
    }

    public static String reformatNumber(String number) {
        String newStr = "";
        for (char c : number.toCharArray()) {
            if (c != ' ' && c != '-') {
                newStr += c;
            }
        }
        char[] str = newStr.toCharArray();
        int len = str.length;
        if (len <= 3) {
            return newStr;
        }
        int end = len;
        String tail = "";
        if (len % 3 == 1) {
            end = end - 4;
            tail = "-" + newStr.substring(end, end + 2) + "-" + newStr.substring(end + 2);
        } else if (len % 3 == 2) {
            end = end - 2;
            tail = "-" + newStr.substring(end);
        }

        String ans = "";
        for (int i = 0; i < end; i++) {
            if (i % 3 == 0) {
                ans += "-" + str[i];
            } else {
                ans += str[i];
            }
        }
        return (ans + tail).substring(1);
    }
}
