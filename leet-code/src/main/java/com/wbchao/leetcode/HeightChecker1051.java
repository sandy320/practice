package com.wbchao.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeightChecker1051 {

    public int heightChecker(int[] heights) {
        int[] sort = heights.clone();
        Arrays.sort(sort);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sort[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }
}
