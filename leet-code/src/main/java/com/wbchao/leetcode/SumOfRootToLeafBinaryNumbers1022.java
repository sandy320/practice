package com.wbchao.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfRootToLeafBinaryNumbers1022 {

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


    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int ans) {
        if (root == null) {
            return 0;
        }
        ans = (ans << 1) + root.val;
        if (root.left == null && root.right == null) {
            return ans;
        }
        return dfs(root.left, ans) + dfs(root.right, ans);
    }

}
