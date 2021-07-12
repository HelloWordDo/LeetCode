package com.leetcode.string.hard;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class IsMatch_10 {

    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {

                char pp = p.charAt(j - 1);

                if (i == 0) {
                    if (pp == '*') {
                        if (j > 1) {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            dp[i][j] = true;
                        }
                    }
                } else {

                    char ss = s.charAt(i - 1);

                    if (ss == pp || pp == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pp == '*') {

                        //case 1 看看如果匹配0个前面元素（删掉前一位）看看和s 是否匹配
                        if (dp[i][j - 2]) {
                            dp[i][j] = true;
                        } else {

                            //case 2 看看如果匹配1~n个前面元素看看和s 是否匹配。
                            //需要看看p前一位和s位字符是否匹配 &&
                            if ((p.charAt(j - 2) == ss || p.charAt(j - 2) == '.') && dp[i - 1][j]) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {

        IsMatch_10 method = new IsMatch_10();

        System.out.println("[aa-->a]:" + method.isMatch("aa", "a"));
        System.out.println("[aa-->a*]:" + method.isMatch("aa", "a*"));
        System.out.println("[ab-->.*]:" + method.isMatch("ab", ".*"));
        System.out.println("[aab-->c*a*b]:" + method.isMatch("aab", "c*a*b"));
        System.out.println("[mississippi-->mis*is*p*.]:" + method.isMatch("mississippi", "mis*is*p*."));
    }
}
