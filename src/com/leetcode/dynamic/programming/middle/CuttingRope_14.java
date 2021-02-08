package com.leetcode.dynamic.programming.middle;

/**
 * 面试题14- I. 剪绳子
 */
public class CuttingRope_14 {

    public static int cuttingRope(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] m = new int[n + 1];
        m[1] = 1;
        m[2] = 2;
        m[3] = 3;

        for (int i = 4; i <= n; i++) {

            for (int j = 1; j <= i / 2; j++) {

                m[i] = Math.max(m[i], j * m[i - j]);
            }
        }
        return m[n];
    }


    public static void main(String[] args) {
        System.out.println("结果：" + cuttingRope(10));
    }
}
