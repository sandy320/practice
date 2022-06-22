package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CutOffTreesForGolfEvent675 {

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> f1 = new ArrayList<>();
        List<Integer> f2 = new ArrayList<>();
        List<Integer> f3 = new ArrayList<>();
        f1.add(2);
        f1.add(3);
        f1.add(4);
        f2.add(0);
        f2.add(0);
        f2.add(5);
        f3.add(8);
        f3.add(7);
        f3.add(6);
        forest.add(f1);
        forest.add(f2);
        forest.add(f3);
        System.out.println(cutOffTree(forest));

    }

    public static int cutOffTree(List<List<Integer>> forest) {
        int M = forest.size();
        int N = forest.get(0)
                      .size();

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (forest.get(i)
                          .get(j) > 1) {
                    trees.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        trees.sort((a, b) -> a[2] - b[2]);

        int ans = 0;
        int sr = 0;
        int sc = 0;
        for (int[] tree : trees) {
            int step = bestWalk(forest, sr, sc, tree[0], tree[1]);
            if (step == -1) {
                return -1;
            }
            ans += step;
            sr = tree[0];
            sc = tree[1];
            forest.get(sr)
                  .set(sc, 1);
        }
        return ans;
    }

    static int[] next = {-1, 0, 1, 0, -1};

    public static int bestWalk(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int M = forest.size();
        int N = forest.get(0)
                      .size();
        boolean[][] visit = new boolean[M][N];
        Deque<int[]> deque = new LinkedList<>();
        deque.addFirst(new int[]{0, sr, sc});
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int step = cur[0];
            int cr = cur[1];
            int cc = cur[2];
            visit[cr][cc] = true;
            if (cr == tr && cc == tc) {
                return step;
            }
            for (int i = 1; i < 5; i++) {
                int nr = cr + next[i - 1];
                int nc = cc + next[i];
                if (nr < 0 || nc < 0 || nr >= M || nc >= N || visit[nr][nc] || forest.get(nr)
                                                                                     .get(nc) == 0) {
                    continue;
                }
                if ((i == 1 && cr > tr) || (i == 2 && cc < tc) || (i == 3 && cr < tr) || (i == 4 && cc > tc)) {
                    deque.addFirst(new int[]{step + 1, nr, nc});
                } else {
                    deque.addLast(new int[]{step + 1, nr, nc});
                }
            }
        }

        return -1;
    }
}
