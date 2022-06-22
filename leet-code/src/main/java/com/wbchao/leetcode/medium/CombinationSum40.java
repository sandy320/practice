package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum40 {

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(arr, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        process(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void process(int[] candidates, int preIndex, int rest, List<Integer> pre, List<List<Integer>> ans) {
        if (rest == 0) {
            ans.add(new ArrayList<>(pre));
            return;
        }
        if (rest < 0) {
            return;
        }
        int N = candidates.length;
        for (int i = preIndex; i < N; i++) {
            if (rest < candidates[preIndex]) {
                break;
            }
            if (i > preIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            pre.add(candidates[i]);
            process(candidates, i + 1, rest - candidates[i], pre, ans);
            pre.remove(pre.size() - 1);
        }
    }

}
