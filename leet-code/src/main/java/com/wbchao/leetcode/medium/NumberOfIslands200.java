package com.wbchao.leetcode.medium;

import java.util.Stack;

public class NumberOfIslands200 {

    public int numIslands2(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    infect(grid, i, j);
                }
            }
        }
        return ans;
    }

    public static void infect(char[][] grid, int x, int y) {
        int M = grid.length;
        int N = grid[0].length;
        if (x < 0 || y < 0 || x >= M || y >= N) {
            return;
        }
        Stack<int[]> stack = new Stack<>();
        if (grid[x][y] == '1') {
            stack.push(new int[]{x, y});
        }
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int curX = cur[0];
            int curY = cur[1];
            grid[curX][curY] = '2';
            infect(grid, curX + 1, curY);
            infect(grid, curX - 1, curY);
            infect(grid, curX, curY + 1);
            infect(grid, curX, curY - 1);
        }
    }

    public int numIslands(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    uf.union(i, j, i + 1, j);
                    uf.union(i, j, i - 1, j);
                    uf.union(i, j, i, j + 1);
                    uf.union(i, j, i, j - 1);
                }
            }
        }
        return uf.sets;
    }

    public static class UnionFind {

        int M;
        int N;
        int len;
        int[] parent;
        int[] size;
        int[] help;
        private int sets;
        char[][] grid;

        public UnionFind(char[][] grid) {
            this.grid = grid;
            M = grid.length;
            N = grid[0].length;
            len = M * N;
            parent = new int[len];
            size = new int[len];
            help = new int[len];
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < N; c++) {
                    if (grid[r][c] == '1') {
                        int i = index(r, c);
                        parent[i] = i;
                        size[i] = 1;
                        sets++;
                    }
                }
            }
        }

        public int index(int x, int y) {
            return x * N + y;
        }

        // 原始位置 -> 下标
        private int find(int i) {
            int hi = 0;
            while (i != parent[i]) {
                help[hi++] = i;
                i = parent[i];
            }
            for (hi--; hi >= 0; hi--) {
                parent[help[hi]] = i;
            }
            return i;
        }

        public void union(int r1, int c1, int r2, int c2) {
            if (!isValid(r1, c1) || !isValid(r2, c2)) {
                return;
            }
            int i1 = index(r1, c1);
            int i2 = index(r2, c2);
            int f1 = find(i1);
            int f2 = find(i2);
            if (f1 != f2) {
                if (size[f1] >= size[f2]) {
                    size[f1] += size[f2];
                    parent[f2] = f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                sets--;
            }
        }

        public int sets() {
            return sets;
        }

        public boolean isValid(int x, int y) {
            if (x < 0 || y < 0 || x >= M || y >= N || grid[x][y] != '1') {
                return false;
            }
            return true;
        }
    }

}
