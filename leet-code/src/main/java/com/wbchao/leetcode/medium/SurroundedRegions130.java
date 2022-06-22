package com.wbchao.leetcode.medium;

public class SurroundedRegions130 {

    public static void main(String[] args) {
        char[][] board = {{'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O'}, {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X'}, {'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O'}, {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O'}, {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O'}, {'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X'}, {'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'}, {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}};
        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=================================");
        solve(board);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        int M = board.length;
        int N = board[0].length;
        UnionFind uf = new UnionFind(board);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                uf.union(i, j, i - 1, j);
                uf.union(i, j, i + 1, j);
                uf.union(i, j, i, j + 1);
                uf.union(i, j, i, j - 1);
            }
        }
        uf.solve();
    }

    public static class UnionFind {

        int M;
        int N;
        int len;
        int[] size;
        int[] parent;
        int[] help;
        int sets;
        char[][] board;
        boolean[] isBoarder;

        public UnionFind(char[][] b) {
            board = b;
            M = board.length;
            N = board[0].length;
            len = M * N;
            size = new int[len];
            parent = new int[len];
            help = new int[len];
            isBoarder = new boolean[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
            sets = len;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == 0 || j == 0 || i == M - 1 || j == N - 1) {
                        isBoarder[index(i, j)] = true;

                    }
                }
            }
        }

        public int find(int i) {
            int hi = 0;
            while (parent[i] != i) {
                help[hi++] = i;
                i = parent[i];
            }
            for (int j = hi - 1; j >= 0; j--) {
                parent[help[j]] = i;
            }
            return i;
        }

        public boolean isValid(int r, int c) {
            if (r < 0 || c < 0 || r >= M || c >= N) {
                return false;
            } else {
                return true;
            }
        }

        public void union(int r1, int c1, int r2, int c2) {
            if (!isValid(r1, c1) || !isValid(r2, c2)) {
                return;
            }
            if (board[r1][c1] != 'O' || board[r2][c2] != 'O') {
                return;
            }
            int index1 = index(r1, c1);
            int index2 = index(r2, c2);

            int f1 = find(index1);
            int f2 = find(index2);
            if (f1 == f2) {
                return;
            }
            int size1 = size[f1];
            int size2 = size[f2];
            if (size1 > size2) {
                size[f1] += size2;
                parent[f2] = f1;
                size[f2] = 0;
                if (isBoarder[f2]) {
                    isBoarder[f1] = true;
                }
            } else {
                size[f2] += size1;
                parent[f1] = f2;
                size[f1] = 0;
                if (isBoarder[f1]) {
                    isBoarder[f2] = true;
                }
            }
            sets--;
        }

        public int index(int r, int c) {
            return r * N + c;
        }

        public void solve() {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 'O' && !isBoarder[find(index(i, j))]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
