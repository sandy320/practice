package com.wbchao.leetcode;

public class OneAwayLcci {

    public static void main(String[] args) {
        String first = "teacher";
        String second = "beacher";
        System.out.println(oneEditAway(first, second));
    }

    public static boolean oneEditAway(String first, String second) {
        char[] str1 = first.toCharArray();
        char[] str2 = second.toCharArray();

        int M = str1.length;
        int N = str2.length;

        if (N < M) {
            return oneEditAway(second, first);
        }

        if (N - M > 1) {
            return false;
        }
        if (M == 0) {
            return true;
        }
        int diffCount = 0;
        int i = 0;
        int j = 0;
        while (diffCount <= 1 && i < M && j < N) {
            if (str1[i] != str2[j]) {
                diffCount++;
                if (M < N) {
                    i--;
                }
            }
            i++;
            j++;
        }
        return diffCount <= 1;
    }
}
