package com.wbchao.leetcode.offer;

public class Offer53 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        //  System.out.println(search(nums, 4));
        System.out.println(missingNumber(nums));
    }

    public static int search(int[] nums, int target) {
        int index = find(nums, target);
        if (index == -1) {
            return 0;
        }
        int L = index;
        int R = index;
        while (L >= 0 && nums[L] == target) {
            L--;
        }
        while (R < nums.length && nums[R] == target) {
            R++;
        }
        return R - L - 1;
    }

    public static int missingNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 0 ? 1 : 0;
        }
        int N = nums.length;
        int L = 0;
        int R = N - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] > mid) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L == nums[L] ? L + 1 : L;
    }


    public static int find(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return nums[L] == target ? L : -1;
    }
}
