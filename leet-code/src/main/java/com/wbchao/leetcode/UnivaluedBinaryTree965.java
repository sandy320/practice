package com.wbchao.leetcode;

public class UnivaluedBinaryTree965 {

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

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root,root.val);

    }

    public boolean process(TreeNode root, int val){
        if(root==null){
            return true;
        }
        if(root.val != val){
            return false;
        }
        if(!process(root.left,val)){
            return false;
        }
        if(!process(root.right,val)){
            return false;
        }
        return true;
    }

}
