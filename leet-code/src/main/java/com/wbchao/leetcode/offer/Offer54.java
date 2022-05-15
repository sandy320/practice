package com.wbchao.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer54 {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return list.get(k - 1);
    }

    public static void process(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        process(root.right, list);
        list.add(root.val);
        process(root.left, list);
    }
}
