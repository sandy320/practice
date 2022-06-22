package com.wbchao.leetcode;

public class KokoEatingBananas875 {

    public static void main(String[] args) {
        int[] piles = {1, 1, 1, 999999999};
        int h = 10;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int N = piles.length;
        int max = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, piles[i]);
            sum += piles[i];
        }
        if (h >= sum) {
            return 1;
        }
        if (h == N) {
            return max;
        }
        int L = 1;
        int R = max;
        int ans = 1;
        while (L <= R) {
            //以mid的速度吃
            int mid = L + (R - L) / 2;
            int time = hours(piles, mid);
            if (time <= h) {
                //吃的太快了，mid太大了
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static int hours(int[] piles, int speed) {
        int ans = 0;
        int offset = speed - 1;
        for (int pile : piles) {
            ans += (pile + offset) / speed;
        }
        return ans;
    }
}
