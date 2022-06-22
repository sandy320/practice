package com.wbchao.leetcode;

public class FindBottomLeftTreeValue513 {

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

    public int findBottomLeftValue(TreeNode root) {
        return process(root).val;
    }

    public static class Info {

        int val;
        int height;

        public Info(int v, int h) {
            val = v;
            height = h;
        }
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(0,0);
        }

        Info left = process(root.left);
        Info right = process(root.right);

        if (left.height == 0 && right.height == 0) {
            return new Info(root.val, 1);
        }
        Info h = left.height >= right.height ? left : right;
        return new Info(h.val, h.height + 1);
    }
}
