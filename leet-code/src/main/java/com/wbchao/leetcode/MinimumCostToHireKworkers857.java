package com.wbchao.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToHireKworkers857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        // 用一个数组保存每名工人的情况，记录性价比。
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i] = new double[]{(double) wage[i] / quality[i], (double) quality[i]};
        }
        // 注意保存的是预期工资和工作质量的比，越小性价比越高，按照第一个关键字升序排序。
        Arrays.sort(workers, (x, y) -> Double.compare(x[0], y[0]));
        double res = Double.MAX_VALUE;
        // 保存当前选中工人的工作质量总和。
        double sum = 0.0F;
        // 大顶堆保存当前选中的 k 个人的工作质量情况。
        PriorityQueue<Double> heap = new PriorityQueue<>((x, y) -> Double.compare(y, x));
        // 当前遍历到的是目前性价比最低的。
        for (double[] worker : workers) {
            // 如果当前已经安排了 k 个人，肯定先去掉质量最大的工人。
            if (heap.size() == k) {
                sum -= heap.poll();
            }
            // 先将当前性价比最低的工人加入。
            sum += worker[1];
            heap.offer(worker[1]);
            // 如何计算需要的最小工资？这样考虑，假设有三个工人 x1, x2, x3...，他们的质量是 q(x1), q(x2), q(x3)...，期望是 e(x1), e(x2), e(x3)...，实际分配的为 f(x1), f(x2), f(x3)..，有 q(x1)/f(x1) = q(x2)/f(x2) = q(x3)/f(x3) = ... = k，则对于所有的 xn，有 q(x)/k = f(x) >= e(x)，...，即 q(x)/e(x) >= k，则要满足所有这样的，则要优先满足 q(x)/e(x) 最小的，即满足性价比最低的，也就是当前的 worker[0]，那么 worker[0] * sum 就可以满足所有的工人的最低需求了。
            if (heap.size() == k) {
                res = Math.min(res, sum * worker[0]);
            }
        }
        return res;
    }

}
