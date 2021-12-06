package com.leetcode.dynamic.programming.hard;

/**
 * 115. 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例 2：
 * <p>
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 */
public class NumDistinct_115 {

    public int numDistinct(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int[][] dp = new int[t.length()][s.length()];

        for (int i = 0; i < t.length(); i++) {

            for (int j = 0; j < s.length(); j++) {

                if (i > j) {
                    continue;
                }

                if (t.charAt(i) == s.charAt(j)) {

                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                        continue;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else {

                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    }
                } else {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length() - 1][s.length() - 1];
    }


    public static void main(String[] args) {
        NumDistinct_115 method = new NumDistinct_115();
        System.out.println(method.numDistinct("babgbag", "bag"));
        System.out.println(method.numDistinct("rabbbit", "rabbit"));
        System.out.println(method.numDistinct("rabbbbbit", "rabbit"));
        System.out.println(method.numDistinct("rabbbbbiitt", "rabbit"));
        System.out.println(method.numDistinct("", ""));
    }
}
