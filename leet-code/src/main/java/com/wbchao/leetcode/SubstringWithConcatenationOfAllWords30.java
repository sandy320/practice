package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords30 {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        int N = words.length;
        int all = len * N;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i + all <= s.length(); i++) {
            int res = process(s, words, new boolean[N], i, N);
            if (res != -1) {
                ans.add(res);
            }
        }
        return ans;
    }

    public static int process(String s, String[] words, boolean[] used, int index, int rest) {
        int len = words[0].length();
        int N = words.length;
        if (rest == 0) {
            int all = len * N;
            return index - all;
        }

        String cur = s.substring(index, index + len);
        int ans = -1;
        for (int i = 0; i < N; i++) {
            if (!used[i] && cur.equals(words[i])) {
                used[i] = true;
                ans = process(s, words, used, index + len, rest - 1);
                if (ans != -1) {
                    break;
                }
                used[i] = false;
            }
        }
        return ans;
    }

}
