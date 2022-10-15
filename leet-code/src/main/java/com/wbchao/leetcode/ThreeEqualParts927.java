package com.wbchao.leetcode;

public class ThreeEqualParts927 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0};
        int[] ans = threeEqualParts(arr);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] threeEqualParts(int[] arr) {
        int N = arr.length;
        int[] num = new int[N];
        num[0] = arr[0];
        for (int i = 1; i < N; i++) {
            num[i] = (num[i - 1] << 1) | arr[i];
        }
        for (int i = 0; i < N; i++) {
            int p1 = num[i];
            for (int j = i + 1; j < N - 1; j++) {
                // i+1 ... j
                int p2 = num[j] ^ (num[i] << (j - i));
                if (p1 == p2) {
                    // j+1 ... N-1
                    int p3 = num[N - 1] ^ (num[j] << (N - j - 1));
                    if (p1 == p3) {
                        return new int[]{i, j + 1};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] threeEqualParts2(int[] arr) {
        int N = arr.length;
        int cntOne = 0;
        for (int num : arr) {
            if (num == 1) {
                cntOne++;
            }
        }
        if (cntOne % 3 != 0) {
            return new int[]{-1, -1};
        }
        int sizeOne = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                sizeOne++;
            }

        }
        return null;
    }

    public static int getNum(int[] arr, int s, int e) {
        int ans = 0;
        for (int i = s; i < e; i++) {
            ans <<= 1;
            ans |= arr[i];
        }
        return ans;
    }

}
