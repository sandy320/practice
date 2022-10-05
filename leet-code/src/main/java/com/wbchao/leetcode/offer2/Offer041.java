package com.wbchao.leetcode.offer2;

import java.util.LinkedList;

public class Offer041 {

    class MovingAverage {

        int size;
        LinkedList<Integer> linkedList;
        int sum;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            linkedList = new LinkedList<>();

        }

        public double next(int val) {
            if (linkedList.size() == size) {
                int poll = linkedList.pollFirst();
                sum = sum - poll;
            }
            linkedList.addLast(val);
            sum += val;
            return (double) sum / (double) linkedList.size();
        }
    }
}
