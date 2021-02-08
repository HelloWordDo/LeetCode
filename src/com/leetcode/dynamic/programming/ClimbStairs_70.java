package com.leetcode.dynamic.programming;

/**
 * 70.爬楼梯
 */
public class ClimbStairs_70 {

    public static int climbStairs(int n) {

        int[] f = new int[n];
        if (n == 1) {
            f[0] = 1;
        }
        if (n == 2) {
            f[1] = 2;
        }
        if (n > 2) {
            f[0] = 1;
            f[1] = 2;
        }

        for (int i = 2; i < n; i++) {

            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + climbStairs(13));
    }
}
