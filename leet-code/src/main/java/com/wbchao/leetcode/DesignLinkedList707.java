package com.wbchao.leetcode;

public class DesignLinkedList707 {

    class Node {

        int val;
        Node next;
        Node prev;

        public Node(int v) {
            val = v;
        }
    }


    class MyLinkedList {

        Node head;
        Node tail;
        int size;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index < 0 || index > size - 1) {
                return -1;
            }
            Node node = find(index);
            return node.val;
        }

        public void addAtHead(int val) {
            Node n = new Node(val);
            if (size == 0) {
                head = n;
                tail = n;
            } else {
                n.next = head;
                head.prev = n;
                head = n;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node n = new Node(val);
            if (size == 0) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                n.prev = tail;
                tail = n;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index == size) {
                addAtTail(val);
            } else if (index > size) {
                return;
            } else if (index <= 0) {
                addAtHead(val);
            } else {
                Node n = new Node(val);
                Node node = find(index);
                node.prev.next = n;
                n.prev = node.prev;
                n.next = node;
                node.prev = n;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size || size == 0) {
                return;
            }
            if (size == 1) {
                head = null;
                tail = null;
            } else if (index == 0) {
                head.next.prev = null;
                head = head.next;
            } else if (index == size - 1) {
                tail = tail.prev;
                tail.next = null;
            } else {
                Node node = find(index);
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        private Node find(int index) {
            Node node = null;
            if (index <= size / 2) {
                int cur = 0;
                node = head;
                while (cur != index) {
                    node = node.next;
                    cur++;
                }
            } else {
                int cur = size - 1;
                node = tail;
                while (cur != index) {
                    node = node.prev;
                    cur--;
                }
            }
            return node;
        }
    }

}
