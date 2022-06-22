package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        //   System.out.println(subsets(nums));
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        process(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void process(int[] nums, int i, List<Integer> pre, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(pre));
            return;
        }
        process(nums, i + 1, pre, ans);
        pre.add(nums[i]);
        process(nums, i + 1, pre, ans);
        pre.remove(pre.size() - 1);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        process2(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    //去重
    public static void process2(int[] nums, int i, List<Integer> pre, List<List<Integer>> ans) {
        int N = nums.length;
        if (i == N) {
            ans.add(new ArrayList<>(pre));
            return;
        }


        // 记录当前位置是什么数值（令数值为 t），并找出数值为 t 的连续一段
        int t = nums[i];
        int last = i;
        while (last < N && nums[last] == t) {
            last++;
        }

        // 不选当前位置的元素，直接跳到 last 往下决策
        process2(nums, last, pre, ans);

        // 决策选择不同个数的 t 的情况：选择 1 个、2 个、3 个 ... k 个
        for (int j = i; j < last; j++) {
            pre.add(nums[j]);
            process2(nums, last, pre, ans);
        }

        // 回溯对数值 t 的选择
        for (int j = i; i < last; i++) {
            pre.remove(pre.size() - 1);
        }
    }
}
