package com.wbchao.leetcode.offer;

public class Offer20 {

    public static void main(String[] args) {
        System.out.println(match("123"));
    }

    public boolean isNumber(String s) {
        char[] str = s.trim()
                      .toCharArray();
        int N = str.length;
        int index = 0;
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasSign = false;
        boolean hasDot = false;
        while (index < N) {
            while (index < N && str[index] >= '0' && str[index] <= '9') {
                index++;
                hasNum = true;
            }
            if (index == N) {
                break;
            }
            char c = str[index];
            if (c == 'e' || c == 'E') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                hasNum = false;
                hasSign = false;
                hasDot = false;
            } else if (c == '+' || c == '-') {
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == ' ') {
                break;
            } else {
                return false;
            }
            index++;
        }

        return hasNum && index == N;
    }

    public static boolean match(String s) {
        String numReg = "[\\+|\\-]?[([0-9]+\\.[0-9]*)|\\.[0-9]+]";
        boolean hasE = false;
        int indexE = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (hasE) {
                    return false;
                } else {
                    hasE = true;
                    indexE = i;
                }
            }
        }
        if (hasE) {
            if (indexE == s.length() - 1) {
                return false;
            }
            String str1 = s.substring(0, indexE);
            String str2 = s.substring(indexE + 1, s.length());
            return str1.matches(numReg) || str2.matches(numReg);
        } else {
            return s.matches(numReg);
        }
    }
}
