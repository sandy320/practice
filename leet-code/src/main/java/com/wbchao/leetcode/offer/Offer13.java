package com.wbchao.leetcode.offer;

public class Offer13 {

    public static void main(String[] args) {
        System.out.println(movingCount(7, 2, 3));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = getSum(i) + getSum(j);
            }
        }
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, visited, k, 0, 0);
    }

    public static int dfs(int[][] grid, boolean[][] visited, int k, int x, int y) {
        int M = grid.length;
        int N = grid[0].length;
        if (x < 0 || y < 0 || x == M || y == N || visited[x][y]) {
            return 0;
        }

        if (grid[x][y] > k) {
            return 0;
        }

        visited[x][y] = true;
        grid[x][y] = Integer.MAX_VALUE;
        int p1 = dfs(grid, visited, k, x + 1, y);
        int p2 = dfs(grid, visited, k, x, y + 1);
        int ans = p1 + p2;
        return ans + 1;
    }

    public static int getSum(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}
