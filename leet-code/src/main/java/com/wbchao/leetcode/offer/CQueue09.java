package com.wbchao.leetcode.offer;

import java.util.Stack;

public class CQueue09 {

    int[] stack1;
    int[] stack2;
    int size1;
    int size2;


    public CQueue09() {
        stack1 = new int[10000];
        stack2 = new int[10000];
    }

    public void appendTail(int value) {
        stack1[size1++] = value;
    }

    public int deleteHead() {
        if (size2 == 0) {
            while (size1 != 0) {
                stack2[size2++] = stack1[--size1];
            }
        }

        return size2 == 0 ? -1 : stack2[--size2];
    }
}
