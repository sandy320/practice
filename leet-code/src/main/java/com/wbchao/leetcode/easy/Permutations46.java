package com.wbchao.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Permutations46 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 1};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, ans);
        return ans;
    }

    public static void dfs(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(Arrays.stream(nums)
                          .boxed()
                          .collect(Collectors.toList()));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, index, i);
            dfs(nums, index + 1, ans);
            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
