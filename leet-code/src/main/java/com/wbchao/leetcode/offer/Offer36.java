package com.wbchao.leetcode.offer;


public class Offer36 {

    public static class Node {

        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + '}';
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);

        treeToDoublyList(root);
    }

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node[] info = process(root);
        Node head = info[0];
        Node tail = info[1];
        head.left = tail;
        tail.right = head;
        return head;
    }

    public static class Info {

        Node head;
        Node tail;

        public Info(Node h, Node t) {
            head = h;
            tail = t;
        }
    }

    public static Node[] process(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return new Node[]{node, node};
        }

        Node[] leftInfo = process(node.left);
        Node[] rightInfo = process(node.right);

        Node head = node;
        Node tail = node;
        if (leftInfo != null) {
            head = leftInfo[0];
            leftInfo[1].right = node;
            node.left = leftInfo[1];
        }

        if (rightInfo != null) {
            tail = rightInfo[1];
            node.right = rightInfo[0];
            rightInfo[0].left = node;
        }
        return new Node[]{head, tail};
    }
}
