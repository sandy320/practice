package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees1305 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(-10);
        root1.right = new TreeNode(10);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(2);

        System.out.println(getAllElements(root1, root2));

    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);

        List<Integer> ans = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1) < list2.get(i2)) {
                ans.add(list1.get(i1++));
            } else if (list1.get(i1) == list2.get(i2)) {
                ans.add(list1.get(i1++));
                ans.add(list2.get(i2++));
            } else {
                ans.add(list2.get(i2++));
            }
        }
        while (i1 < list1.size()) {
            ans.add(list1.get(i1++));
        }

        while (i2 < list2.size()) {
            ans.add(list2.get(i2++));
        }
        return ans;
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        }
    }

}


class TreeNode {

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

