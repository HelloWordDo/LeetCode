package com.leetcode.dynamic.programming;

/**
 * 392. 判断子序列
 */
public class IsSubsequence_392 {

    public static boolean isSubsequence(String s, String t) {

        if (s.equals("")) {
            return true;
        }
        int j = 0;

        for (int i = 0; i < t.length(); i++) {

            if (s.charAt(j) == t.charAt(i)) {
                ++j;
            }
            if (j == s.length() && i <= t.length() - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + isSubsequence("dc", "ahbgdc"));
    }
}
