package com.wbchao.leetcode;

public class VerifyingAnAlienDictionary953 {

    public static void main(String[] args) {
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        char[] orderC = order.toCharArray();
        int[] alphaBet = new int[26];
        for (int i = 0; i < orderC.length; i++) {
            alphaBet[orderC[i] - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(words[i + 1])) {
                continue;
            }
            if (!compare(words[i], words[i + 1], alphaBet)) {
                return false;
            }
        }
        return true;
    }

    // w1 小 返回ture
    // w1,w2不一样
    public static boolean compare(String w1, String w2, int[] alphaBet) {
        if (w1.length() > w2.length()) {
            return !compare(w2, w1, alphaBet);
        }
        for (int i = 0; i < w1.length(); i++) {
            int index1 = w1.charAt(i) - 'a';
            int index2 = w2.charAt(i) - 'a';
            if (index1 == index2) {
                continue;
            } else {
                return alphaBet[index1] < alphaBet[index2];
            }
        }
        return true;
    }
}
