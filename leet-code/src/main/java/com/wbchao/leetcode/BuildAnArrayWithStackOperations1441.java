package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations1441 {

    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 4;
        List<String> ans = buildArray(target, n);
        System.out.println(ans);
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        process(target, 0, 0, ans);
        return ans;
    }

    public static void process(int[] target, int pre, int index, List<String> ans) {
        if (index == target.length) {
            return;
        }
        for (int i = pre + 1; i < target[index]; i++) {
            ans.add("Push");
            ans.add("Pop");
        }
        ans.add("push");
        process(target, target[index], index + 1, ans);
    }
}
