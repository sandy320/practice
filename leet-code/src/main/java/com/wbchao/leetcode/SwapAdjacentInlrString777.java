package com.wbchao.leetcode;

public class SwapAdjacentInlrString777 {

    public static void main(String[] args) {
        String start = "LXXLXRLXXL", end = "XLLXRXLXLX";
        System.out.println(canTransform(start, end));
    }

    public static boolean canTransform(String start, String end) {
        int N = start.length();
        int i = 0, j = 0;
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        while (true) {
            while (i < N && start.charAt(i) == 'X') {
                i++;
            }
            while (j < N && end.charAt(j) == 'X') {
                j++;
            }
            if (i == N && j == N) {
                return true;
            }
            if (i == N || j == N || s[i] != e[j]) {
                return false;
            }
            if (s[i] == 'L' && i < j || s[i] == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
    }
}
