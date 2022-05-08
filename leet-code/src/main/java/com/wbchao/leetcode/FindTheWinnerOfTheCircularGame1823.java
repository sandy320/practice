package com.wbchao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheWinnerOfTheCircularGame1823 {

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    public static int findTheWinner(int n, int k) {
        Node head = new Node(1);
        Node pre = head;
        int count = n;
        for (int i = 2; i <= n; i++) {
            Node cur = new Node(i);
            pre.next = cur;
            pre = cur;
        }
        pre.next = head;
        while (count > 1) {
            for (int i = 0; i < k - 1; i++) {
                pre = pre.next;
                head = head.next;
            }
            count--;
            pre.next = head.next;
            head = head.next;
        }
        return head.val;
    }

    public static class Node {

        int val;
        Node next;

        public Node(int i) {
            val = i;
        }
    }
}
