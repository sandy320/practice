package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, char[]> dict = generateDict();
        process(dict, digits.toCharArray(), 0, "", ans);
        return ans;
    }

    public static Map<Character, char[]> generateDict() {
        Map<Character, char[]> dict = new HashMap<>();
        dict.put('2', new char[]{'a', 'b', 'c'});
        dict.put('3', new char[]{'d', 'e', 'f'});
        dict.put('4', new char[]{'g', 'h', 'i'});
        dict.put('5', new char[]{'j', 'k', 'l'});
        dict.put('6', new char[]{'m', 'n', 'o'});
        dict.put('7', new char[]{'p', 'q', 'r', 's'});
        dict.put('8', new char[]{'t', 'u', 'v'});
        dict.put('9', new char[]{'w', 'x', 'y', 'z'});

        return dict;
    }

    public static void process(Map<Character, char[]> dict, char[] digits, int index, String pre, List<String> ans) {
        if (index == digits.length) {
            ans.add(pre);
            return;
        }
        char cur = digits[index];
        char[] chooses = dict.get(cur);
        for (char digit : chooses) {
            process(dict, digits, index + 1, pre + digit, ans);
        }
    }
}
