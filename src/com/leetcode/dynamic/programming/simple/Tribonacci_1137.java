package com.leetcode.dynamic.programming.simple;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 */
public class Tribonacci_1137 {

    public int tribonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int d1 = 0;
        int d2 = 1;
        int d3 = 1;

        for (int i = 3; i <= n; i++) {
            int d4 = d1 + d2 + d3;
            d1 = d2;
            d2 = d3;
            d3 = d4;
        }

        return d3;

    }

    public static void main(String[] args) {

        Tribonacci_1137 method = new Tribonacci_1137();
        System.out.println(method.tribonacci(4));
    }
}
