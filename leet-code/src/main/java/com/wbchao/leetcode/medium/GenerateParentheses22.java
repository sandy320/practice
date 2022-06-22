package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        process(new char[n << 1], 0, 0, n, ans);
        return ans;
    }

    public void process(char[] pre, int index, int leftMinusRight, int restLeft, List<String> ans) {
        if (index == pre.length) {
            ans.add(String.valueOf(pre));
            return;
        }

        if (restLeft > 0) {
            pre[index] = '(';
            process(pre, index + 1, leftMinusRight + 1, restLeft - 1, ans);
        }

        if (leftMinusRight > 0) {
            pre[index] = ')';
            process(pre, index + 1, leftMinusRight - 1, restLeft, ans);
        }
    }

}
