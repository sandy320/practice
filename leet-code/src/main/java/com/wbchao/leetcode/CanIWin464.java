package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CanIWin464 {

    public static void main(String[] args) {
        System.out.println(canIWin(4, 6));
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if ((maxChoosableInteger * (maxChoosableInteger + 1) >> 1) < desiredTotal) {
            return false;
        }

        int[] arr = new int[maxChoosableInteger];
        for (int i = 0; i < maxChoosableInteger; i++) {
            arr[i] = i + 1;
        }

        int[] dp = new int[1 << (maxChoosableInteger + 1)];
        //  return process(new boolean[maxChoosableInteger + 1], desiredTotal);
        return process(maxChoosableInteger, 0, desiredTotal, dp);
    }

    public static boolean process(boolean[] usedNums, int rest) {
        if (rest <= 0) {
            return false;
        }

        for (int i = 1; i < usedNums.length; i++) {
            if (usedNums[i]) {
                continue;
            }
            int chooseNum = i;
            usedNums[chooseNum] = true;
            boolean result = process(usedNums, rest - chooseNum);
            usedNums[chooseNum] = false;
            if (!result) {
                return true;
            }
        }
        return false;
    }

    //status 位信息记录是否用过，0表示未使用
    public static boolean process(int max, int status, int rest, int[] dp) {
        if (rest <= 0) {
            return false;
        }
        if (dp[status] != 0) {
            return dp[status] == 1;
        }

        for (int i = 1; i <= max; i++) {
            if (((1 << i) & status) != 0) {
                continue;
            }
            boolean next = process(max, status | (1 << i), rest - i, dp);
            if (!next) {
                dp[status] = 1;
                return true;
            }
        }
        dp[status] = -1;
        return false;
    }
}
