package com.leetcode.array.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 */
public class OrangesRotting_994 {

    public int orangesRotting(int[][] grid) {

        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {

                    queue.add(new int[]{i, j});
                    grid[i][j] = 0;
                    visited[i][j] = true;
                } else if (grid[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {

            int[] q = queue.poll();
            for (int[] d : distance) {

                int x = q[0] + d[0];
                int y = q[1] + d[1];

                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && visited[x][y] == false) {

                    grid[x][y] = grid[q[0]][q[1]] + 1;
                    res = grid[x][y];
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    return -1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        OrangesRotting_994 method = new OrangesRotting_994();
        System.out.println(method.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));

    }
}
