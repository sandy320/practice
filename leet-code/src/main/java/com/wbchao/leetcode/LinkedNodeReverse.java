package com.wbchao.leetcode;

public class LinkedNodeReverse {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printNodeList(n1);
        printNodeList(reverse(n1));
    }

    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur !=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void printNodeList(Node head){
        for (Node n = head; n != null; n = n.next) {
            System.out.print("==" + n.value);
        }
        System.out.println();
    }
}



class Node {

    int value;
    Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }
}