package com.wbchao.leetcode;

public class DefuseTheBomb1652 {

    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 3;
        code = decrypt(code, k);
        for (int c : code) {
            System.out.printf(c + " ");
        }
    }

    public static int[] decrypt(int[] code, int k) {
        int N = code.length;
        if (k == 0) {
            return new int[N];
        }
        int[] help = new int[2 * N];
        for (int i = 0; i < N; i++) {
            help[i] = code[i];
            help[i + N] = code[i];
        }
        for (int i = 1; i < help.length; i++) {
            help[i] += help[i - 1];
        }
        for (int i = 0; i < N; i++) {
            code[i] = k > 0 ? help[i + k] - help[i] : help[i + N - 1] - help[i + N + k - 1];
        }
        return code;
    }
}
