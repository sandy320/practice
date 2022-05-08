package com.wbchao.leetcode;

import java.util.PriorityQueue;

public class NextPermutation31 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.printf(" " + i);
        }
    }

    public static void nextPermutation(int[] nums) {
        int N = nums.length;
        int index = N - 2;
        while (index >= 0) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
            index--;
        }
        if (index < 0) {
            sort(nums, 0, N - 1);
        } else {
            int value = nums[index];
            for (int i = N - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, index, i);
                    sort(nums, index + 1, N - 1);
                    return;
                }
            }
        }
    }

    public static void sort(int[] arr, int L, int R) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = L; i <= R; i++) {
            heap.add(arr[i]);
        }
        for (int i = L; i <= R; i++) {
            arr[i] = heap.poll();
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
