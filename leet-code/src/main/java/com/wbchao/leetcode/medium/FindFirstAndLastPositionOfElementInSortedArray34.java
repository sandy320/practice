package com.wbchao.leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findLeft(nums, 0));
        System.out.println(findRight(nums, 0));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = findLeft(nums, target);
        int right = findRight(nums, target);

        return new int[]{left, right};
    }

    public static int findLeft(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] < target) {
                L = mid + 1;
            } else {
                index = mid;
                R = mid - 1;
            }
        }
        if (index == -1) {
            return index;
        }
        return nums[index] == target ? index : -1;
    }

    public static int findRight(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] <= target) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        if (index == -1) {
            return index;
        }
        return nums[index] == target ? index : -1;
    }
}
