package com.wbchao.leetcode.offer;

public class Offer18 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        if (k > count) {
            return null;
        }
        int index = 0;
        cur = head;
        while (index++ < count - k) {
            cur = cur.next;
        }
        return cur;
    }
}
