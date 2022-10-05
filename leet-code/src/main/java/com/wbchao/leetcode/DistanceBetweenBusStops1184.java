package com.wbchao.leetcode;

public class DistanceBetweenBusStops1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        if (start > destination) {
            return distanceBetweenBusStops(distance, destination, start);
        }
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (i >= start && i < destination) {
                ans += distance[i];
            }
        }
        return Math.min(ans, sum - ans);
    }
}
