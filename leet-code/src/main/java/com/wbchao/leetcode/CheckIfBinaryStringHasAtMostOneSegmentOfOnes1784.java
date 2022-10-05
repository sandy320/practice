package com.wbchao.leetcode;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes1784 {
    public boolean checkOnesSegment(String s) {
        if(s.equals("0")){
            return true;
        }
        char[] str = s.toCharArray();
        boolean haseOne = false;
        for(char c : str){
            if(haseOne && c == '1'){
                return false;
            }
            if(c == '0'){
                haseOne = true;
            }
        }
        return true;
    }
}
