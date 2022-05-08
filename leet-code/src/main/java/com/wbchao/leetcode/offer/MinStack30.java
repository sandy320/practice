package com.wbchao.leetcode.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class MinStack30 {

    int[] queue;
    int[] stack;
    int queueSize;
    int stackSize;

    public static void main(String[] args) {
        MinStack30 minStack = new MinStack30();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    public MinStack30() {
        queue = new int[20000];
        stack = new int[20000];
    }

    public void push(int x) {
        stack[stackSize++] = x;
        if (queueSize == 0 || queue[queueSize - 1] >= x) {
            queue[queueSize++] = x;
        }
    }

    public void pop() {
        int res = stack[--stackSize];
        if (res == queue[queueSize - 1]) {
            queueSize--;
        }
    }

    public int top() {
        return stack[stackSize - 1];
    }

    public int min() {
        return queue[queueSize - 1];
    }
}
