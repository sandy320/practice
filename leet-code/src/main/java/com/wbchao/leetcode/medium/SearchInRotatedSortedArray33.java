package com.wbchao.leetcode.medium;

public class SearchInRotatedSortedArray33 {

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        if (nums[minIndex] == target) {
            return minIndex;
        } else if (nums[nums.length - 1] >= target) {
            return find(nums, target, minIndex, nums.length - 1);
        } else {
            return find(nums, target, 0, minIndex);
        }
    }

    public static int find(int[] nums, int target, int L, int R) {
        int mid = L;
        while (L < R) {
            mid = L + (R - L) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return nums[L] == target ? mid : -1;
    }

    public static int findMinIndex(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] >= nums[L] && nums[mid] > nums[R]) {
                L = mid + 1;
            } else if (nums[mid] < nums[L] && nums[mid] < nums[R]) {
                R = mid;
            } else if (nums[mid] >= nums[L] && nums[mid] <= nums[R]) {
                break;
            }
        }
        return L;
    }
}
