package com.leetcode.dynamic.programming.middle;

/**
 * 375. 猜数字大小 II
 * <p>
 * n=6时，答案是8
 * <p>
 * 从1~6依次选择
 * 如果不对，有如下两种可能：
 * <p>
 * 答案比3大，此时分成[1，2]和[4，5，6]。
 * 1）[1,2]==>最小1就够==>3+1=4;
 * 2)[4,5,6]==>最小5就够==>3+5=8;
 * 所以当第一次选择3时候，至少要8才够。
 * 假设选择4，如果不对，有如下两种可能：
 * 此时分成[1，3]和[5，6]。
 */
public class GetMoneyAmount_375 {

    public static int getMoneyAmount(int n) {

        if (n == 0 || n == 1) return 0;

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 2; i <= n; i++) {

            for (int j = i - 1; j > 0; j--) {

                if (j == i - 1) {
                    dp[j][i] = j;
                    continue;
                }
                if (i - j == 2) {
                    dp[j][i] = j + 1;
                    continue;
                }

                int min = 0;
                for (int k = j; k <= i; k++) {

                    if (k == j) {
                        min = k + dp[k + 1][i];
                        continue;
                    }
                    if (j - k == 1) {
                        min = Math.min(k + dp[k + 1][i], min);
                        continue;
                    }

                    if (i - k == 1 || i == k) {
                        min = Math.min(k + dp[j][k - 1], min);
                        continue;
                    }
                    min = Math.min(Math.max(k + dp[j][k - 1], k + dp[k + 1][i]), min);
                }
                dp[j][i] = min;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + getMoneyAmount(46));
    }
}
