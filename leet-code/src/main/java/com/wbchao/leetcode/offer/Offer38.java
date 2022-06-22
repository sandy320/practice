package com.wbchao.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Offer38 {

    public static void main(String[] args) {
        System.out.println(permutation("aac"));
    }

    public static String[] permutation(String s) {
        char[] str = s.toCharArray();
        int N = str.length;
        Arrays.sort(str);
        Set<String> ans = new HashSet<>();
        process(str, new boolean[N], 0, "", ans);
        System.out.println(ans);
        return ans.toArray(new String[ans.size()]);
    }

    public static void process(char[] str, boolean[] visit, int index, String pre, Set<String> ans) {
        int N = str.length;
        if (index == N) {
            ans.add(pre);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                process(str, visit, index + 1, pre + str[i], ans);
                visit[i] = false;
            }
        }
    }

    public static String[] permutation2(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        char[] str = s.toCharArray();
        g2(str, 0, ans);
        return ans.toArray(new String[ans.size()]);
    }

    public static void g2(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            boolean[] visited = new boolean[256];
            for (int i = index; i < str.length; i++) {
                if (!visited[str[i]]) {
                    visited[str[i]] = true;
                    swap(str, index, i);
                    g2(str, index + 1, ans);
                    swap(str, index, i);
                }
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
