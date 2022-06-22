package com.wbchao.leetcode.offer;

public class Offer07 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode process(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);

        if (L1 == R1) {
            return head;
        }
        int find = L2;
        while (pre[L1] != in[find]) {
            find++;
        }
        TreeNode left = process(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        TreeNode right = process(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        head.left = left;
        head.right = right;
        return head;
    }
}
