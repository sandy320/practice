package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations47 {

    public static void main(String[] args) {
        int[] nums = {1,1, 1, 3};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int N = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        process(nums, new boolean[N], new ArrayList<>(), ans);
        return ans;
    }

    public static void process(int[] nums, boolean[] used, List<Integer> res, List<List<Integer>> ans) {
        int N = nums.length;
        if (res.size() == N) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                res.add(nums[i]);
                used[i] = true;
                process(nums, used, res, ans);
                used[i] = false;
                res.remove(res.size() - 1);
            }
        }
    }
}
