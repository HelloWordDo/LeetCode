package com.leetcode.backtracking.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class SolveNQueens_51 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        String[][] board = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }

        backtrack(n, board, 0, 0);
        return res;
    }

    private void backtrack(int n, String[][] board, int i, int count) {

        if (count == n) {

            List<String> track = new ArrayList<>();
            for (int j = 0; j < n; j++) {

                String s = "";
                for (int k = 0; k < n; k++) {
                    s += board[j][k];
                }
                track.add(s);
            }
            res.add(track);
            return;
        }

        for (int l = 0; l < n; l++) {

            if (board[i][l] == "." && check(n, board, i, l)) {
                board[i][l] = "Q";
                backtrack(n, board, ++i, ++count);
                --i;
                --count;
                board[i][l] = ".";
            } else if (l == n - 1) {
                return;
            }
        }
    }


    boolean check(int n, String[][] board, int i, int j) {

        //判断当前纵坐标之前
        for (int k = i - 1; k >= 0; k--) {
            if (board[k][j] == "Q") {
                return false;
            }

        }
        //判断当前横坐标之前
        for (int k = j - 1; k >= 0; k--) {
            if (board[i][k] == "Q") {
                return false;
            }
        }

        int p = i, q = j;
        //判断左上
        while (p > 0 && q > 0) {
            --p;
            --q;
            if (board[p][q] == "Q") {
                return false;
            }
        }

        int s = i, v = j;
        //判断右上
        while (s > 0 && v < n - 1) {
            --s;
            ++v;
            if (board[s][v] == "Q") {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        SolveNQueens_51 method = new SolveNQueens_51();
        List<List<String>> res = method.solveNQueens(4);
        System.out.println(res);
    }
}
