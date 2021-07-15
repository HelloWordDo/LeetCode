package com.leetcode.array.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * 输出：
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * 示例 2：
 * <p>
 * 输入：
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * 输出：
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
public class UpdateMatrix_542 {

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {

                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] distance = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {

            int[] s = queue.poll();

            for (int[] d : distance) {

                int i = s[0] + d[0];
                int j = s[1] + d[1];

                if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == -1) {

                    mat[i][j] = mat[s[0]][s[1]] + 1;
                    queue.add(new int[]{i, j});
                }
            }

        }
        return mat;
    }


    public static void main(String[] args) {

        UpdateMatrix_542 method = new UpdateMatrix_542();
        method.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }
}
