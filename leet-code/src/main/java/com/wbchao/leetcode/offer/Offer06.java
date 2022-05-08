package com.wbchao.leetcode.offer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer06 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }


    public static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        //     reversePrint(n1);
        ListNode head = reverse(n1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        ListNode pre = head;
        ListNode cur = head.next;
        int size = 1;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            size++;
        }
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = pre.val;
            pre = pre.next;
        }
        return ans;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> newMap = new HashMap<>();
        Node cur = head;
        Node newHead = new Node(head.val);
        Node newCur = newHead;
        newMap.put(head, newHead);
        while (cur.next != null) {
            newCur.next = new Node(cur.next.val);
            newMap.put(cur.next, newCur.next);
            cur = cur.next;
            newCur = newCur.next;
        }
        cur = head;
        newCur = newHead;
        while(cur !=null){
            if(cur.random !=null){
                Node newRandom = newMap.get(cur.random);
                newCur.random = newRandom;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}
