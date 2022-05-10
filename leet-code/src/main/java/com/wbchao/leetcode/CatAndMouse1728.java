package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CatAndMouse1728 {

    /**
     * 一只猫和一只老鼠在玩一个叫做猫和老鼠的游戏。
     *
     * 它们所处的环境设定是一个 rows x cols 的方格 grid ，其中每个格子可能是一堵墙、一块地板、一位玩家（猫或者老鼠）或者食物。
     *
     * 玩家由字符 'C' （代表猫）和 'M' （代表老鼠）表示。
     * 地板由字符 '.' 表示，玩家可以通过这个格子。
     * 墙用字符 '#' 表示，玩家不能通过这个格子。
     * 食物用字符 'F' 表示，玩家可以通过这个格子。
     * 字符 'C' ， 'M' 和 'F' 在 grid 中都只会出现一次。
     * 猫和老鼠按照如下规则移动：
     *
     * 老鼠 先移动 ，然后两名玩家轮流移动。
     * 每一次操作时，猫和老鼠可以跳到上下左右四个方向之一的格子，他们不能跳过墙也不能跳出 grid 。
     * catJump 和 mouseJump 是猫和老鼠分别跳一次能到达的最远距离，它们也可以跳小于最大距离的长度。
     * 它们可以停留在原地。
     * 老鼠可以跳跃过猫的位置。
     * 游戏有 4 种方式会结束：
     *
     * 如果猫跟老鼠处在相同的位置，那么猫获胜。
     * 如果猫先到达食物，那么猫获胜。
     * 如果老鼠先到达食物，那么老鼠获胜。
     * 如果老鼠不能在 1000 次操作以内到达食物，那么猫获胜。
     * 给你 rows x cols 的矩阵 grid 和两个整数 catJump 和 mouseJump ，双方都采取最优策略，如果老鼠获胜，那么请你返回 true ，否则返回 false 。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/cat-and-mouse-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] grid = {"####F","#C...","M...."};
        int catJump = 1;
        int mouseJump = 2;

        System.out.println(canMouseWin(grid, catJump, mouseJump));
    }

    public static boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int M = grid.length;
        int N = 0;
        for (int i = 0; i < M; i++) {
            N = Math.max(N, grid[i].length());
        }
        int mX = 0;
        int mY = 0;
        int cX = 0;
        int cY = 0;
        char[][] box = new char[M][N];
        //转成字符数组，初始猫和老鼠位置设置为.
        //记录猫和老鼠初始坐标
        for (int i = 0; i < M; i++) {
            char[] line = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                //防止给定字符串不一样长，原题好像是等长的
                if (j >= line.length) {
                    box[i][j] = '#';
                } else if (line[j] == 'C') {
                    cX = i;
                    cY = j;
                    box[i][j] = '.';
                } else if (line[j] == 'M') {
                    mX = i;
                    mY = j;
                    box[i][j] = '.';
                } else {
                    box[i][j] = line[j];
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(box[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("M: " + mX + " " + mY);
        System.out.println("C: " + cX + " " + cY);

        //分别缓存当前是猫，鼠状况下的结果
        int[][][][] dpM = new int[M][N][M][N];
        int[][][][] dpC = new int[M][N][M][N];
        return process(box, catJump, mouseJump, true, 0, mX, mY, cX, cY, dpM, dpC);
    }

    // isCurM true表示当前是老鼠移动，false表示当前猫移动
    // step 当前已走的步数
    // mX,mY,cX,cY当前的猫鼠坐标
    // 返回当前情况下谁赢， true--老鼠赢， false--猫赢
    public static boolean process(char[][] box, int catJump, int mouseJump, boolean isCurM, int step, int mX, int mY, int cX, int cY,
                                  int[][][][] dpM, int[][][][] dpC) {

        System.out.println("Step: " + step);
        System.out.println("M: " + mX + " " + mY);
        System.out.println("C: " + cX + " " + cY);
        System.out.println("===================================");

        if (isCurM && dpM[mX][mY][cX][cY] != 0) {
            return dpM[mX][mY][cX][cY] == 1;
        }

        if (!isCurM && dpC[mX][mY][cX][cY] != 0) {
            return dpC[mX][mY][cX][cY] == 1;
        }

        // 重合，猫赢
        if (mX == cX && mY == cY) {
            return false;
        }

        //老鼠找到食物，老鼠赢
        if (box[mX][mY] == 'F') {
            return true;
        }

        //猫找到食物，猫赢
        if (box[cX][cY] == 'F') {
            return false;
        }

        // 超过1000步，猫赢
        if (step > 1000) {
            return false;
        }
        boolean ans = false;
        //老鼠回合
        if (isCurM) {
            List<int[]> total = getValidPos(box, mX, mY, mouseJump);
            for (int[] pos : total) {
                // 枚举老鼠所有可能去的点，若有一个返回true，老鼠赢
                if (process(box, catJump, mouseJump, false, step + 1, pos[0], pos[1], cX, cY, dpM, dpC)) {
                    ans = true;
                    break;
                }
            }
            dpM[mX][mY][cX][cY] = ans ? 1 : -1;
            return ans;
        } else {
            ans = true;
            //猫回合, 枚举所有猫能去的点，若有一个返回false,猫赢
            List<int[]> total = getValidPos(box, cX, cY, catJump);
            for (int[] pos : total) {
                if (!process(box, catJump, mouseJump, true, step + 1, mX, mY, pos[0], pos[1], dpM, dpC)) {
                    ans = false;
                    break;
                }
            }
            dpC[mX][mY][cX][cY] = ans ? 1 : -1;
            return ans;
        }
    }

    //从x,y出发，走limit步内的所有合法坐标，包括当前自己位置
    public static List<int[]> getValidPos(char[][] box, int x, int y, int limit) {
        List<int[]> total = new ArrayList<>();
        total.add(new int[]{x, y});
        int M = box.length;
        int N = box[0].length;
        for (int i = 1; i <= limit; i++) {
            //上 遇到边界或者#停止
            if (x - i < 0 || box[x - i][y] == '#') {
                break;
            }
            total.add(new int[]{x - i, y});
        }
        for (int i = 1; i <= limit; i++) {
            //下 遇到边界或者#停止
            if (x + i >= M || box[x + i][y] == '#') {
                break;
            }
            total.add(new int[]{x + i, y});
        }
        for (int i = 1; i <= limit; i++) {
            //左 遇到边界或者#停止
            if (y - i < 0 || box[x][y - i] == '#') {
                break;
            }
            total.add(new int[]{x, y - i});
        }
        for (int i = 1; i <= limit; i++) {
            //右 遇到边界或者#停止
            if (y + i >= N || box[x][y + i] == '#') {
                break;
            }
            total.add(new int[]{x, y + i});
        }
        return total;
    }
}
