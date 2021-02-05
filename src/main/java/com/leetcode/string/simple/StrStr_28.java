package com.leetcode.string.simple;

/**
 * 28. 实现 strStr()
 */
public class StrStr_28 {

    public static int strStr(String haystack, String needle) {

        int res = -1;

        if (haystack == null || needle == null) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return res;
        }
        if (haystack.equals(needle) || needle.equals("")) {
            return 0;
        }

        int i = 0, j = 0;

        while (i < haystack.length() && j < needle.length()) {

            if (haystack.length() - i < needle.length() - j) {
                return res;
            }
            char a = haystack.charAt(i);
            char b = needle.charAt(j);
            if (a == b) {
                res = i - j;
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
                res = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + strStr("mississippi", "mississippi"));
    }
}
