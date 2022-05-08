package com.wbchao.leetcode.offer;

public class Offer11 {

    public static void main(String[] args) {
        int[] nums = {10, 10, 10, 10, 1, 10, 10, 10};
        System.out.println(minArray(nums));
    }

    public static int minArray(int[] numbers) {
        if (numbers[0] < numbers[numbers.length - 1]) {
            return numbers[0];
        }
        int L = 0;
        int R = numbers.length - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (numbers[mid] > numbers[R]) {
                L = mid + 1;
            } else if (numbers[mid] < numbers[R]) {
                R = mid;
            } else {
                R--;
            }
        }
        return numbers[L];
    }
}
