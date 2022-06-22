package com.wbchao.leetcode.offer;

import java.util.Stack;

public class Offer31 {

    public static void main(String[] args) {
        int[] pushed = {1, 0};
        int[] popped = {1, 0};
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int pushIndex = 0;
        while (popIndex < popped.length) {
            if (stack.isEmpty() && pushIndex < pushed.length) {
                stack.push(pushed[pushIndex++]);
            }
            int cur = popped[popIndex];
            while (!stack.isEmpty() && stack.peek() != cur && pushIndex < pushed.length) {
                stack.push(pushed[pushIndex++]);
            }
            if (stack.peek() == cur) {
                stack.pop();
            }
            popIndex++;
        }
        return stack.isEmpty();

    }

    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        int[] stack = new int[pushed.length];
        int size = 0;
        int popIndex = 0;
        int pushIndex = 0;
        while (popIndex < popped.length) {
            if (size == 0 && pushIndex < pushed.length) {
                stack[size++] = pushed[pushIndex++];
            }
            int cur = popped[popIndex];
            while (size > 0 && stack[size - 1] != cur && pushIndex < pushed.length) {
                stack[size++] = pushed[pushIndex++];
            } if (stack[size - 1] == cur) {
                size--;
            }
            popIndex++;
        }
        return size == 0;

    }
}
