package com.wbchao.leetcode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NestedInteger {

    int val;
    List<NestedInteger> list = new ArrayList<>();

    public NestedInteger() {

    }

    public NestedInteger(int val) {
        this.val = val;
    }

    public void add(NestedInteger nestedInteger) {
        list.add(nestedInteger);
    }
}


class Solution {

    public static void main(String[] args) {
        String s = "[123,456,[788,799,833],[[]],10,[]]";
        NestedInteger ans = deserialize(s);
        System.out.println(ans);
    }

    public static NestedInteger deserialize(String s) {
        if (!s.contains("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }
        int N = s.length();
        char[] str = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, NestedInteger> map = new HashMap<>();
        int[] pair = new int[N];

        for (int i = 0; i < N; i++) {
            if (str[i] == '[') {
                stack.push(i);
                map.put(i, new NestedInteger());
            } else if (str[i] == ']') {
                int left = stack.pop();
                pair[left] = i + 1;
            }
        }
        NestedInteger ans = map.get(0);

        convert(ans, map, pair, s, 1, N);

        return ans;
    }

    public static void convert(NestedInteger n, Map<Integer, NestedInteger> map, int[] pair, String s, int L, int R) {
        if (L >= R) {
            return;
        }
        char[] str = s.toCharArray();
        if (str[L] == ']') {
            return;
        }
        int begin = L;
        for (int i = L; i < R; i++) {
            if (str[i] == ',' || str[i] == ']') {
                int value = Integer.parseInt(s.substring(begin, i));
                n.add(new NestedInteger(value));

                begin = i + 1;
            } else if (str[i] == '[') {
                NestedInteger ni = map.get(i);
                n.add(ni);
                convert(ni, map, pair, s, i + 1, pair[i]);
                i = pair[i];
                begin = i + 1;
            }
        }
    }

}
