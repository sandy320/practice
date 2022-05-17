package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sum15 {

    public static void main(String[] args) {
        int[] nums = {-2, -3, 0, 0, -2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            ans.add(Stream.of(0, 0, 0)
                          .collect(Collectors.toList()));
            return ans;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[i] + nums[L] + nums[R] == 0) {
                    ans.add(Stream.of(nums[i], nums[L++], nums[R--])
                                  .collect(Collectors.toList()));
                    while (L < R && nums[L] == nums[L - 1]) {
                        L++;
                    }
                    while (nums[R] == nums[R + 1]) {
                        R--;
                    }
                } else if (nums[i] + nums[L] + nums[R] < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }

}
