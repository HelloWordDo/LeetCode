package com.leetcode.dynamic.programming.middle;

/**
 * 5.最长公共子回文串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestPalindrome_5 {

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {

                char a = s.charAt(i);
                char b = s.charAt(j);

                dp[i][j] = a == b && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    /**
     * 2021.04.21
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {

        if (s.length() == 1) {
            return s;
        }

        String s1 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()][s.length()];

        String res = "";
        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j < s.length(); j++) {

                char a = s.charAt(i);
                char b = s1.charAt(j);

                if (a == b) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (res.length() < dp[i][j]) {

                        int j2 = s.length() - 1 - j;
                        int ii = j2 + dp[i][j] - 1;
                        if (i == ii) {
                            res = s.substring(i - dp[i][j] + 1, i + 1);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + longestPalindrome2("aacabdkacaa"));
    }
}
