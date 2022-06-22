package com.wbchao.leetcode.offer;

public class Offer56 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 3};
        System.out.println(singleNumber(nums));
    }

    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int firstOne = xor & (~xor + 1);
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & firstOne) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = 0;
            for (int num : nums) {
                bit += ((num >> i) & 1);
            }
            bit = bit % 3;
            ans |= (bit << i);
        }
        return ans;
    }
}
