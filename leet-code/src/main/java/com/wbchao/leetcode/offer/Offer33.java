package com.wbchao.leetcode.offer;

public class Offer33 {

    public static void main(String[] args) {
        int[] post = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(verifyPostorder(post));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return process(postorder, 0, postorder.length - 1);
    }

    public static boolean process(int[] post, int L, int R) {
        if (L >= R) {
            return true;
        }
        int root = post[R];
        int m = L;
        while (post[m] < root) {
            m++;
        }
        for (int i = m; i < R; i++) {
            if (post[i] < root) {
                return false;
            }
        }
        return process(post, L, m - 1) && process(post, m, R - 1);
    }
}
