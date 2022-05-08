package com.wbchao.leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = 1;
        int nextLevelSize = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelSize++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelSize++;
            }
            if (--levelSize == 0) {
                levelSize = nextLevelSize;
                nextLevelSize = 0;
                ans.add(list);
                list = new ArrayList<>();
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = 1;
        int nextLevelSize = 0;
        boolean reverse = false;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelSize++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelSize++;
            }
            if (--levelSize == 0) {
                levelSize = nextLevelSize;
                nextLevelSize = 0;
                if (reverse) {
                    Collections.reverse(list);
                }
                ans.add(list);
                reverse = !reverse;
                list = new ArrayList<>();
            }
        }
        return ans;
    }
}
