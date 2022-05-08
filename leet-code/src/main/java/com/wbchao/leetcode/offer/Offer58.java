package com.wbchao.leetcode.offer;

public class Offer58 {

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s, 2));

    }

    public static String reverseLeftWords(String s, int n) {
        char[] str = s.toCharArray();
        int N = str.length;
        n = n % N;
        n = N - n;
        reverse(str, 0, str.length - 1);
        reverse(str, 0, n - 1);
        reverse(str, n, str.length - 1);
        return new String(str);
    }

    public static void reverse(char[] str, int L, int R) {
        while (L < R) {
            char tmp = str[L];
            str[L++] = str[R];
            str[R--] = tmp;
        }
    }
}
