package com.wbchao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum508 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        process(root, map);
        int max = map.values()
                     .stream()
                     .max((a1, a2) -> a1 - a2)
                     .get();
        int count = (int) map.values()
                             .stream()
                             .filter(i -> i == max)
                             .count();
        int[] ans = new int[count];
        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                ans[index++] = key;
            }
        }
        return ans;
    }

    public static int process(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left, map);
        int right = process(root.right, map);
        int sum = left + right + root.val;
        if (map.get(sum) == null) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
        }
        return sum;
    }
}
