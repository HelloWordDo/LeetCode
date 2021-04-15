package com.leetcode.backtracking.medium;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist_79 {

    public boolean exist(char[][] board, String word) {

        int rowLength = board.length;
        int colLength = board[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {

            for (int j = 0; j < colLength; j++) {
                if (backtrack(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int size) {

        if (board[i][j] != word.charAt(size)) {
            return false;
        } else if (size == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {

            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {

                if (!visited[newi][newj]) {
                    if (backtrack(board, word, visited, newi, newj, size + 1)) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;

        return result;
    }


    public static void main(String[] args) {

        Exist_79 method = new Exist_79();

        char[][] a = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean b = method.exist(a, "ABCCED");
        System.out.println("结果：" + b);
    }
}
