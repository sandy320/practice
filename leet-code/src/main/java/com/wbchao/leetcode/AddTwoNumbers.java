package com.wbchao.leetcode;


import java.math.BigDecimal;
import java.util.List;

//  Definition for singly-linked list.
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}


/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

        示例：

        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807

        [9]
        [1,9,9,9,9,9,9,9,9,9]
        [0,0,0,0,0,0,0,0,0,0,1]
*/
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(9);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(1);
        ListNode m3 = new ListNode(1);


        addTwoNumbers(m1, n1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode((l1.val + l2.val) % 10);
        int digit = (l1.val + l2.val) / 10;
        ListNode cur1 = l1.next;
        ListNode cur2 = l2.next;
        ListNode cur = head;
        while (cur1 != null || cur2 != null || digit > 0) {
            int sum = digit + (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val);
            cur.next = new ListNode(sum % 10);
            digit = sum / 10;
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
            cur = cur.next;
        }


        return head;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static int getSize(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
