package com.wbchao.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Combinations77 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> pick = new ArrayDeque<>();
        process(n, k, 1, pick, ans);
        return ans;
    }

    public static void process(int n, int k, int begin, Deque<Integer> pick, List<List<Integer>> ans) {
        if (pick.size() == k) {
            ans.add(new ArrayList<>(pick));
            return;
        }
        for (int i = begin; i <= n; i++) {
            pick.addLast(i);
            process(n, k, i + 1, pick, ans);
            pick.removeLast();
        }
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> pick, List<List<Integer>> ans) {
        // 递归终止条件是：path 的长度等于 k
        if (pick.size() == k) {
            ans.add(new ArrayList<>(pick));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            pick.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, pick, ans);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            pick.removeLast();
        }
    }

}
