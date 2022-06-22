package com.wbchao.leetcode;

public class UniqueSubstringsInWraparoundString467 {

    public static void main(String[] args) {
        String p = "abcdefghijklmnopqrstuvwxyza";
        System.out.println(findSubstringInWraproundString(p));
    }

    public static int findSubstringInWraproundString(String p) {
        char[] str = p.toCharArray();
        int N = str.length;
        //记录以每个字母开头的最大连续长度
        int[] count = new int[26];
        int start = 0;
        int end = 1;
        count[str[N - 1] - 'a'] = 1;
        boolean over = false;
        for (int i = 0; i < N - 1; i++) {
            //寻找连续区间
            if (str[i] + 1 == str[i + 1] || (str[i] == 'z' && str[i + 1] == 'a')) {
                end++;
            } else {
                over = true;
            }
            if (i == N - 2) {
                over = true;
            }
            if (over) {
                //连续中断，结算
                for (int j = start; j < Math.min(end, start + 26); j++) {
                    count[str[j] - 'a'] = Math.max(count[str[j] - 'a'], end - j);
                }
                start = i + 1;
                end = start + 1;
                over = false;
            }
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}
