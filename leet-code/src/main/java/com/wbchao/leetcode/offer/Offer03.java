package com.wbchao.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer03 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
