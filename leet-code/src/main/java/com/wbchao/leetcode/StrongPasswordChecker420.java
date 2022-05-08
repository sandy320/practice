package com.wbchao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class StrongPasswordChecker420 {

    public static void main(String[] args) {
        char[] arr = "aaabaaaaa".toCharArray();
        System.out.println(countSameNum(arr));
    }
    public int strongPasswordChecker(String password) {
        char[] arr = password.toCharArray();
        int N = arr.length;
        if (N <= 4) {
            return 6 - password.length();
        }
        int kinds = kinds(arr);
        if (N == 5) {
            if (kinds == 0) {
                return 3;
            } else if (kinds == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        int countNum = countSameNum(arr);
        if(N >= 6 && N<=20){
            if (kinds == 0) {
                return 3;
            }
        }
        return 0;
    }

    public static int kinds(char[] arr) {
        Set<Integer> set = new HashSet<>();
        for (char c : arr) {
            if ('a' <= c && 'z' >= c) {
                set.add(1);
            } else if ('A' <= c && 'Z' >= c) {
                set.add(2);
            } else if ('0' <= c && '9' >= c) {
                set.add(3);
            }
        }
        return set.size();
    }

    public static int countSameNum(char[] arr) {
        char pre = arr[0];
        int seq = 1;
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == pre) {
                seq++;
            } else {
                seq = 1;
            }
            if (seq == 3) {
                count++;
            }
            if (seq == 6) {
                seq = 1;
                count++;
            }
            pre = arr[i];
        }
        return count;
    }
}
