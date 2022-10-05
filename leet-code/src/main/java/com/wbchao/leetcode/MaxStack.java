package com.wbchao.leetcode;

import java.util.TreeSet;

//Lint859
public class MaxStack {

    public static void main(String[] args) {
        MaxStack ms = new MaxStack();
        ms.push(5);
        ms.push(1);
        ms.push(5);
        System.out.println(ms.top());
        System.out.println(ms.popMax());
        System.out.println(ms.top());
        System.out.println(ms.peekMax());
        System.out.println(ms.pop());
        System.out.println(ms.top());

    }

    Node head;
    Node tail;
    TreeSet<Node> set;
    int cnt;

    public MaxStack() {
        // do intialization if necessary
        set = new TreeSet<>((a, b) -> a.val == b.val ? a.cnt - b.cnt : a.val - b.val);
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        Node cur = new Node(x, cnt++);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.last = tail;
            tail.next = cur;
            tail = cur;
        }
        set.add(cur);
    }

    public int pop() {
        // write your code here
        set.remove(tail);
        int res = tail.val;
        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = tail.last;
            tail.next = null;
        }
        cnt--;
        return res;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return tail.val;
    }

    /*
     * @return: An integer
     */
    public int peekMax() {
        // write your code here
        Node cur = set.last();
        return cur.val;
    }

    /*
     * @return: An integer
     */
    public int popMax() {
        // write your code here
        Node cur = set.last();
        set.remove(cur);
        int res = cur.val;
        if (cur == head) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
        } else if (cur == tail) {
            tail = cur.last;
            cur.last.next = null;
        } else {
            cur.last.next = cur.next;
            cur.next.last = cur.last;
        }
        cnt--;
        return res;
    }

    class Node {

        int val;
        int cnt;
        Node last;
        Node next;

        public Node(int v, int c) {
            val = v;
            cnt = c;
        }
    }
}
