package com.wbchao.leetcode;

public class GenerateAStringWithCharactersThatHaveOddCounts1374 {

    public String generateTheString(int n) {
        String ans = "";
        for (int i = 0; i < n - 1; i++) {
            ans += 'a';
        }
        return (n & 1) == 0 ? ans + 'b' : ans + 'a';
    }
}
