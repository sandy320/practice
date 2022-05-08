package com.wbchao.leetcode.easy;

public class PermutationInString567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int M = str1.length;
        int N = str2.length;

        if (M > N) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < M; i++) {
            count[str1[i] - 'a']++;
        }
        int all = M;

        int R = 0;
        while (R < M) {
            if (count[str2[R++] - 'a']-- > 0) {
                all--;
            }
        }
        int L = 0;
        while (R < N) {
            if (all == 0) {
                return true;
            }
            if (count[str2[R++] - 'a']-- > 0) {
                all--;
            }
            if (count[str2[L++] - 'a']++ >= 0) {
                all++;
            }
        }
        return all == 0;
    }
}
