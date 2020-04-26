package com.leetcode.dynamic.programming;

/**
 * 343.整数拆分
 */
public class IntegerBreak_343 {

    public static int integerBreak(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        for (int i = 4; i <= n; i++) {

            int maxProduct = 0;
            for (int j = 1; j < n; j++) {

                if (i > j)
                    maxProduct = Math.max(maxProduct, j * f[i - j]);
            }
            f[i] = maxProduct;
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + integerBreak(15));
    }
}
