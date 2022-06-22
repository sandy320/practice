package com.wbchao.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTarget797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 从0到n-1爆搜即可
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(resultList, new ArrayList<>(), graph, 0, graph.length);
        return resultList;
    }

    private void dfs(List<List<Integer>> resultList, List<Integer> result, int[][] graph, int i, int n) {
        // 跟下面放在一起也可以，不过递归我们一般把返回值放在前面，这样比较清晰一点
        if (i == n - 1) {
            result.add(i);
            resultList.add(new ArrayList<>(result));
            result.remove(result.size() - 1);
            return;
        }

        result.add(i);
        for (int next : graph[i]) {
            dfs(resultList, result, graph, next, n);
        }
        // 回溯：这里注意下不要用remove(i)或者remove(Integer.valueOf(i))
        result.remove(result.size() - 1);
    }
}
