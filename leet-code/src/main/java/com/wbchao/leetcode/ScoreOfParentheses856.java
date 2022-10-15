package com.wbchao.leetcode;

public class ScoreOfParentheses856 {

    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {
        char[] str = s.toCharArray();
        return process(str, 0)[0];
    }

    public static int[] process(char[] str, int index) {
        if (str[index] == ')') {
            return new int[]{1, index};
        }

        int score = 0;
        while (index < str.length && str[index] != ')') {
            int[] info = process(str, index + 1);
            if (str[info[1] - 1] == '(') {
                score += 1;
            } else {
                score += info[0] * 2;
            }
            index = info[1] + 1;
        }
        return new int[]{score, index};
    }
}
