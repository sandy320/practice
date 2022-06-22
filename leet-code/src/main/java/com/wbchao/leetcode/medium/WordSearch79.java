package com.wbchao.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch79 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;

        char[] str = word.toCharArray();
        boolean[][] used = new boolean[M][N];
        boolean ans = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == str[0]) {
                    ans = dfs(board, used, str, 0, i, j);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return ans;
    }

    static int[] next = {-1, 0, 1, 0, -1};

    public static boolean dfs(char[][] board, boolean[][] used, char[] str, int index, int x, int y) {
        int M = board.length;
        int N = board[0].length;
        if (index == str.length) {
            return true;
        }

        if (x < 0 || y < 0 || x >= M || y >= N) {
            return false;
        }

        boolean result = false;
        if (board[x][y] == str[index] && !used[x][y]) {
            used[x][y] = true;
            for (int i = 1; i < 5; i++) {
                int nextX = x + next[i - 1];
                int nextY = y + next[i];
                result = result || dfs(board, used, str, index + 1, nextX, nextY);
            }
            used[x][y] = false;
        }
        return result;
    }


}
