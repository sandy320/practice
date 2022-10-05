package com.wbchao.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree662 {

    public class TreeNode {

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


    public class Node {

        TreeNode n;
        int index;

        public Node(TreeNode tn, int i) {
            n = tn;
            index = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 1));
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int begin = queue.peek().index;
            int curIndex = begin;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                TreeNode n = cur.n;
                curIndex = cur.index;
                if (n.left != null) {
                    queue.add(new Node(n.left, 2 * curIndex));
                }
                if (n.right != null) {
                    queue.add(new Node(n.right, 2 * curIndex + 1));
                }
            }

            ans = Math.max(ans, curIndex - begin + 1);
        }
        return ans;
    }
}
