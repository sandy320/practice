package com.wbchao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfRefuelingStops871 {

    public static void main(String[] args) {
        int target = 1000000000;
        int startFuel = 145267354;
        int[][] stations = {{32131797, 142290934}, {86397166, 44642653}, {99237057, 56978680}, {130019011, 99649968}, {154227249, 90514223}, {198652959, 102942413}, {272491487, 108474929}, {282220105, 83721209}, {302284128, 43151624}, {318501736, 107636032}, {359336452, 73807027}, {425903682, 43078334}, {447483572, 53751173}, {469840976, 57311636}, {472584505, 57629539}, {531147470, 106487691}, {611722638, 111485731}, {650472592, 20105771}, {692670691, 141572192}, {747847056, 7972504}, {800899205, 106134661}, {825649709, 136473550}, {880534339, 72135820}, {887048383, 73776979}, {967172408, 58930710}};
        System.out.println(minRefuelStops(target, startFuel, stations));
    }


    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) {
            return 0;
        }
        //先到达第一个加油站
        int nextDistance = 0 == stations.length ? target : stations[0][0];
        Map<String, Integer> dp = new HashMap<>();

        return process(target - nextDistance, startFuel - nextDistance, 0, target, stations, dp);
    }

    // 用 dp[i] 表示加油 i 次的最大行驶英里数。
    // 由于初始时汽油量是 startFuel 升
    // 可以行驶 startFuel 英里，因此 dp[0]=startFuel
    public static int dp(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public static int process(int restMiles, int curFuel, int index, int target, int[][] stations, Map<String, Integer> dp) {
        if (curFuel < 0) {
            return -1;
        }
        if (curFuel >= restMiles) {
            return 0;
        }

        if (index == stations.length) {
            return restMiles <= 0 ? 0 : -1;
        }

        String dpKey = restMiles + "_" + curFuel + "_" + index;
        if (dp.get(dpKey) != null) {
            return dp.get(dpKey);
        }

        //本站点到下一站点的距离
        int nextDistance = index == stations.length - 1 ? target - stations[index][0] : stations[index + 1][0] - stations[index][0];

        //两种情况，本站点不加油，本站点加油
        //1. 加油
        int p1 = process(restMiles - nextDistance, curFuel + stations[index][1] - nextDistance, index + 1, target, stations, dp);
        if (p1 != -1) {
            p1++;
        }

        //2. 不加油
        int p2 = process(restMiles - nextDistance, curFuel - nextDistance, index + 1, target, stations, dp);

        int ans = p2 == -1 ? p1 : Math.min(p1, p2);
        dp.put(dpKey, ans);
        return ans;
    }
}
