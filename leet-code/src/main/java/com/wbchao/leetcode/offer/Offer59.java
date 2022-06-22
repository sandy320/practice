package com.wbchao.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if (N == 0) {
            return new int[]{};
        }
        int[] ans = new int[N - k + 1];
        Deque<Integer> qmax = new LinkedList<>();

        int index = 0;
        for (int R = 0; R < N; R++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            if (qmax.peekFirst() == R - k) {
                qmax.pollFirst();
            }
            if (R >= k - 1) {
                ans[index++] = nums[qmax.peekFirst()];
            }
        }
        return ans;
    }

    static class MaxQueue {

        LinkedList<Integer> list;
        Deque<Integer> qmax;

        public MaxQueue() {
            list = new LinkedList<>();
            qmax = new LinkedList<>();
        }

        public int max_value() {
            return qmax.isEmpty() ? -1 : qmax.peekFirst();
        }

        public void push_back(int value) {
            list.addLast(value);
            while (!qmax.isEmpty() && qmax.peekLast() <= value) {
                qmax.pollLast();
            }
            qmax.addLast(value);
        }

        public int pop_front() {
            if (list.isEmpty()) {
                return -1;
            }
            int value = list.pollFirst();
            if (value == qmax.peekFirst()) {
                qmax.pollFirst();
            }
            return value;
        }
    }
}
