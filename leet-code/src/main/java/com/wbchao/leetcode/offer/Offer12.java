package com.wbchao.leetcode.offer;

public class Offer12 {

    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();
        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (process(board, str, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean process(char[][] board, char[] word, int index, int x, int y) {
        int M = board.length;
        int N = board[0].length;

        if (index == word.length) {
            return true;
        }
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return false;
        }
        if (board[x][y] != word[index]) {
            return false;
        }
        board[x][y] = 0;
        boolean ans = false;
        ans = ans || process(board, word, index + 1, x + 1, y);
        ans = ans || process(board, word, index + 1, x - 1, y);
        ans = ans || process(board, word, index + 1, x, y + 1);
        ans = ans || process(board, word, index + 1, x, y - 1);
        board[x][y] = word[index];
        return ans;
    }
}
