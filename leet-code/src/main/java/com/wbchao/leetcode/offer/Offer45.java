package com.wbchao.leetcode.offer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Offer45 {

    public String minNumber(int[] nums) {
        List<String> numStr = Arrays.stream(nums)
                                    .boxed()
                                    .map(n -> String.valueOf(n))
                                    .sorted((a, b) -> (a + b).compareTo((b + a)))
                                    .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (String num : numStr) {
            sb.append(num);
        }
        return sb.toString();
    }
}
