package com.wbchao.leetcode;

public class FindClosestLcci17 {

    public static void main(String[] args) {
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "a";
        String word2 = "student";
        System.out.println(findClosest(words, word1, word2));
    }

    public static int findClosest(String[] words, String word1, String word2) {
        int firstIndex = 0;
        String firstString = null;
        int ans = words.length - 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                // firstString == null表示是第一个
                // 如果当前单词和firstString不一样，收集答案
                if (firstString != null && !words[i].equals(firstString)) {
                    ans = Math.min(ans, i - firstIndex);
                }
                // 更新记录当前index和当前的word为first，去寻找下一个跟他不同的
                firstIndex = i;
                firstString = words[i].equals(word1) ? word1 : word2;
            }
        }
        return ans;
    }
}
