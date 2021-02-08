package com.leetcode.dynamic.programming;

/**
 * 面试题 08.01. 三步问题
 */
public class WaysToStep_0801 {

    public static int waysToStep(int n) {

        int[] s = new int[n + 1];
        s[0] = 1;
        if (n > 1) {
            s[1] = 2;
        }
        if (n > 2) {
            s[2] = 4;
        }
        for (int i = 3; i < n; i++) {
            s[i] = ((s[i - 1] % 1000000007 + s[i - 2] % 1000000007) % 1000000007 + s[i - 3] % 1000000007) % 1000000007;
        }
        return s[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + waysToStep(61));
    }
}
