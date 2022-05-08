package com.wbchao.leetcode;

public class MiddleOfTheLinkedList876 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int removeIndex = count - n;
        if (removeIndex == 0) {
            return head.next;
        }
        cur = head;
        ListNode pre = null;
        while (removeIndex > 1) {
            pre = cur;
            cur = cur.next;
            removeIndex--;
        }

        pre.next = cur.next;
        return head;
    }
}
