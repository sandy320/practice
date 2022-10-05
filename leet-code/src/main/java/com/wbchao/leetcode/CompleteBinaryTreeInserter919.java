package com.wbchao.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter919 {

    public static void main(String[] args) {
        CBTInserter obj = new CBTInserter(new TreeNode(1));
        System.out.println(obj.insert(2));
    }

    static class TreeNode {

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


    static class CBTInserter {

        TreeNode root;
        Queue<TreeNode> queue;
        TreeNode parent;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                TreeNode cur = queue.peek();
                if (cur.left == null && cur.right == null) {
                    parent = cur;
                    queue.poll();
                    break;
                } else if (cur.left != null && cur.right == null) {
                    queue.add(cur.left);
                    parent = cur;
                    queue.poll();
                    break;
                }
                if (cur.right != null) {
                    queue.poll();
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }

        public int insert(int val) {
            TreeNode ans = null;
            if (parent.left == null) {
                parent.left = new TreeNode(val);
                queue.add(parent.left);
                ans = parent;
            } else if (parent.left != null && parent.right == null) {
                parent.right = new TreeNode(val);
                queue.add(parent.right);
                ans = parent;
                parent = queue.poll();
            }
            return ans.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
