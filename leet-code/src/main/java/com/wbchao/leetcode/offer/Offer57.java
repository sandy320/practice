package com.wbchao.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            if (nums[L] + nums[R] == target) {
                return new int[]{nums[L], nums[R]};
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                R--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

    public static int[][] findContinuousSequence(int target) {
        if (target == 1) {
            return new int[][]{{1}};
        }
        if (target == 2) {
            return new int[][]{};
        }
        List<int[]> ans = new ArrayList<>();
        int L = 1;
        int R = 2;
        int sum = L + R;
        while (R <= 1 + target / 2) {
            if (sum == target) {
                int[] res = new int[R - L + 1];
                for (int i = L; i <= R; i++) {
                    res[i - L] = i;
                }
                ans.add(res);
                sum += ++R;
            } else if (sum < target) {
                sum += ++R;
            } else {
                sum -= L++;
            }
        }
        int[][] result = ans.toArray(new int[ans.size()][]);
        return result;
    }
}
