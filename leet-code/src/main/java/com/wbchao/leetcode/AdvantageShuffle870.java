package com.wbchao.leetcode;

import java.util.TreeMap;

public class AdvantageShuffle870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            int key = map.firstKey();
            if (map.higherKey(nums2[i]) != null) {
                key = map.higherKey(nums2[i]);
            }
            nums1[i] = key;
            if (map.get(key) == 1) {
                map.remove(key);
            } else {
                map.put(key, map.get(key) - 1);
            }
        }
        return nums1;
    }
}
