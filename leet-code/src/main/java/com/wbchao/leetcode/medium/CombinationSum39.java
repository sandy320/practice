package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
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
            pre.add(candidates[i]);
            process(candidates, i, rest - candidates[i], pre, ans);
            pre.remove(pre.size() - 1);
        }
    }


}
