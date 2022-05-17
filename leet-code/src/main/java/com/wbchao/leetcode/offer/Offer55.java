package com.wbchao.leetcode.offer;

import sun.reflect.generics.tree.Tree;

public class Offer55 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }

    public static class Info {

        int height;
        boolean isBalance;

        public Info(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info left = process(root.left);
        Info right = process(root.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalance = true;
        if (!left.isBalance || !right.isBalance) {
            isBalance = false;
        }
        if (Math.abs(left.height - right.height) > 1) {
            isBalance = false;
        }
        return new Info(height, isBalance);
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalance;
    }

}
