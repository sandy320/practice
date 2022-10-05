package com.wbchao.leetcode;

import java.util.PriorityQueue;

public class RankTransformOfAnArray1331 {

    public static void main(String[] args) {
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        int[] ans = arrayRankTransform(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] arrayRankTransform(int[] arr) {
        int N = arr.length;
        if (N == 0) {
            return arr;
        }
        int[] ans = new int[N];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) {
            heap.add(new int[]{arr[i], i});
        }
        int[] pre = heap.poll();
        int rank = 1;
        ans[pre[1]] = rank++;
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            if (poll[0] == pre[0]) {
                ans[poll[1]] = ans[pre[1]];
            } else {
                ans[poll[1]] = rank++;
            }
            pre = poll;
        }
        return ans;
    }
}
