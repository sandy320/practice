package com.wbchao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickWithBlacklist710 {

    public static void main(String[] args) {
        Solution solution = new Solution(4, new int[]{2, 1});
    }

    static class Solution {

        int size;
        Map<Integer, Integer> convertMap;

        public Solution(int n, int[] blacklist) {
            size = n - blacklist.length;
            convertMap = new HashMap<>();

            Arrays.sort(blacklist);
            int R = blacklist.length - 1;
            int cur = n - 1;
            for (int i = 0; i < blacklist.length; i++) {
                while (R >= 0 && cur == blacklist[R]) {
                    cur--;
                    R--;
                }
                convertMap.put(blacklist[i], cur);
                cur--;
            }
        }

        public int pick() {
            int index = new Random().nextInt(size);
            return convertMap.containsKey(index) ? convertMap.get(index) : index;
        }
    }
}
