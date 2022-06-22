package com.wbchao.leetcode.medium;

import java.util.Stack;

public class NumberOfProvinces547 {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(findCircleNum2(grid));
    }

    public static int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected);
        int N = isConnected.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.sets;
    }

    public static class UnionFind {

        int[] parent;
        int[] help;
        int[] size;
        int sets;
        int N;

        public UnionFind(int[][] grid) {
            N = grid.length;
            parent = new int[N];
            help = new int[N];
            size = new int[N];
            sets = N;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            int hi = 0;
            while (i != parent[i]) {
                help[hi++] = i;
                i = parent[i];
            }
            for (int j = hi - 1; j >= 0; j--) {
                parent[help[j]] = i;
            }
            return i;
        }

        public void union(int p1, int p2) {
            int f1 = find(p1);
            int f2 = find(p2);
            if (f1 == f2) {
                return;
            }
            int size1 = size[f1];
            int size2 = size[f2];

            if (size1 >= size2) {
                size[f1] += size[f2];
                size[f2] = 0;
                parent[f2] = f1;
            } else {
                size[f2] += size[f1];
                size[f1] = 0;
                parent[f1] = f2;
            }
            sets--;
        }
    }

    public static int findCircleNum2(int[][] isConnected) {
        int N = isConnected.length;
        boolean[] visit = new boolean[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                dfs(isConnected, visit, i);
                ans++;
            }
        }
        return ans;
    }

    public static void dfs(int[][] grid, boolean[] visit, int i) {
        int N = grid.length;
        int[] stack = new int[N * N];
        int size = 0;
        stack[size++] = i;
        while (size > 0) {
            int cur = stack[--size];
            visit[cur] = true;
            for (int j = 0; j < N; j++) {
                if (!visit[j] && grid[cur][j] == 1) {
                    stack[size++] = j;
                }
            }
        }
    }
}
