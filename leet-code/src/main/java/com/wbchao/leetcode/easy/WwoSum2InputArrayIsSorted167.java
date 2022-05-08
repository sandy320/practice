package com.wbchao.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class WwoSum2InputArrayIsSorted167 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 24, 50, 79, 88, 150, 345};
        twoSum2(nums, 200);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]) + 1, i + 1};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            int L = i + 1;
            int R = nums.length - 1;
            int findIndex = find(nums, L, R, find);
            if (findIndex != -1) {
                return new int[]{i + 1, findIndex + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static int find(int[] nums, int L, int R, int target) {
        if (L == R) {
            return nums[L] == target ? L : -1;
        }
        int mid = L + (R - L) / 2;
        int ans = -1;
        if (nums[mid] == target) {
            ans = mid;
        } else if (nums[mid] < target) {
            ans = find(nums, mid + 1, R, target);
        } else if (nums[mid] > target) {
            ans = find(nums, L, mid, target);
        }
        return ans;
    }
}
