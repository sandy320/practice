package com.wbchao.leetcode;

public class MinimumSwapsToMakeSequencesIncreasing801 {

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 3, 5, 7};
        int[] nums2 = {0, 1, 4, 9, 10};
        System.out.println(minSwap2(nums1, nums2));
    }

    public static int minSwap2(int[] A, int[] B) {
        int N = A.length;
        int[] dpKeep = new int[N];
        int[] dpSwap = new int[N];
        for (int i = 0; i < N; i++) {
            dpSwap[i] = Integer.MAX_VALUE;
            dpKeep[i] = Integer.MAX_VALUE;
        }
        dpKeep[0] = 0;
        dpSwap[0] = 1;
        for (int i = 1; i < N; i++) {
            if ((A[i] > A[i - 1] && B[i] > B[i - 1]) && (A[i] > B[i - 1] && B[i] > A[i - 1])) {
                //既可以交换，也可以不交换
                dpKeep[i] = Math.min(dpKeep[i - 1], dpSwap[i - 1]);
                dpSwap[i] = 1 + Math.min(dpKeep[i - 1], dpSwap[i - 1]);
                continue;
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                //前一位交换, 本位不交换
                dpKeep[i] = dpSwap[i - 1];
                //前一位不交换，本位交换
                dpSwap[i] = 1 + dpKeep[i - 1];
            }

            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                //前一位不交换，本位也不交换
                dpKeep[i] = dpKeep[i - 1];
                //前一位交换了，本位也必须交换
                dpSwap[i] = 1 + dpSwap[i - 1];
            }
        }
        return Math.min(dpKeep[N - 1], dpSwap[N - 1]);
    }

    public static int minSwap(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int max = nums1[0];
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nums1[i]);
            max = Math.max(max, nums2[i]);
        }
        int[][][] dp = new int[max + 1][max + 1][N];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return process(nums1, nums2, nums1[0], nums2[0], 1, dp);
    }

    public static int process(int[] arr1, int[] arr2, int pre1, int pre2, int i, int[][][] dp) {
        if (i == arr1.length) {
            return 0;
        }
        if (dp[pre1][pre2][i] != -1) {
            return dp[pre1][pre2][i];
        }
        if (arr1[i] < pre1 && arr2[i] < pre1) {
            return Integer.MAX_VALUE;
        }
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        if (arr1[i] > pre1 && arr2[i] > pre2) {
            p1 = process(arr1, arr2, arr1[i], arr2[i], i + 1, dp);
        }
        if (arr2[i] > pre1 && arr1[i] > pre2) {
            //交换
            p2 = 1 + process(arr1, arr2, arr2[i], arr1[i], i + 1, dp);
        }
        dp[pre1][pre2][i] = Math.min(p1, p2);
        return dp[pre1][pre2][i];
    }

}
