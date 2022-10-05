package com.wbchao.leetcode.binarysearch;

public class Leet744 {

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] == target) {
            return letters[0];
        }

        int index = process(letters, target, 0, letters.length - 1);
        return letters[index];
    }

    public static int process(char[] letters, char target, int L, int R) {
        if (L == R) {
            return (L == letters.length - 1 && letters[L] <= target) ? 0 : L;
        }

        int mid = L + (R - L) / 2;
        if (letters[mid] <= target) {
            return process(letters, target, mid + 1, R);
        } else {
            return process(letters, target, L, mid);
        }

    }
}
