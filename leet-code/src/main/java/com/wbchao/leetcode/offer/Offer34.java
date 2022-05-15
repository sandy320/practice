package com.wbchao.leetcode.offer;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Offer34 {

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

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                parent.put(cur.left, cur);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                parent.put(cur.right, cur);
                queue.add(cur.right);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        process(root, target, ans, parent);
        return ans;
    }

    public static void process(TreeNode node, int target, List<List<Integer>> ans, Map<TreeNode, TreeNode> parent) {
        if (node == null) {
            return;
        }

        if (node.val == target && node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            TreeNode cur = node;
            while (cur != null) {
                list.add(0, cur.val);
                cur = parent.get(cur);
            }
            ans.add(list);
        }
        process(node.left, target - node.val, ans, parent);
        process(node.right, target - node.val, ans, parent);
    }

}
