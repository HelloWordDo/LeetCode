package com.leetcode.dynamic.programming.middle;

/**
 * 91. 解码方法
 */
public class NumDecodings_91 {

    public static int numDecodings(String s) {

        int[] n = new int[s.length()];

        if (s.charAt(0) == '0' || s.length() == 0) return 0;

        n[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0')) {
                return 0;
            }
            if (s.charAt(i) == '0') {
                if (n[i - 1] > 1) {
                    if (i - 2 < 0) {
                        return 0;
                    }
                    n[i] = n[i - 2];
                } else {
                    n[i] = n[i - 1];
                }
                continue;
            }
            if (s.charAt(i - 1) == '0') {
                n[i] = n[i - 1];
                continue;
            }

            if (s.charAt(i - 1) > '2') {
                n[i] = n[i - 1];
                continue;
            }
            if (s.charAt(i - 1) == '2' && s.charAt(i) >= '7') {
                if (i - 1 < 0) {
                    return 0;
                }
                n[i] = n[i - 1];
                continue;
            }

            if (i - 2 < 0) {
                n[i] = n[i - 1] + 1;
            } else {
                n[i] = n[i - 1] + n[i - 2];
            }
        }
        return n[s.length() - 1];
    }


    public static void main(String[] args) {
        System.out.println("结果：" + numDecodings("110"));
    }
}
