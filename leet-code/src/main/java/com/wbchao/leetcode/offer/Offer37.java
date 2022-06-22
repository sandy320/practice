package com.wbchao.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Offer37 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<String> queue = new LinkedList<>();
        pres(root, queue);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(",")
              .append(queue.poll());
        }
        return sb.substring(1);
    }

    public static void pres(TreeNode root, Queue<String> queue) {
        if (root == null) {
            queue.add(null);
            return;
        }
        queue.add(String.valueOf(root.val));
        pres(root.left, queue);
        pres(root.right, queue);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : str) {
            queue.add(s);
        }
        return pred(queue);
    }

    public static TreeNode pred(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String cur = queue.poll();
        if ("null".equals(cur)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = pred(queue);
        root.right = pred(queue);
        return root;
    }
}
