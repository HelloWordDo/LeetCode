package com.leetcode.dynamic.programming.middle;

/**
 * 877. 石子游戏
 */
public class StoneGame_877 {

    public static boolean stoneGame(int[] piles) {

        int[][] dp = new int[piles.length][piles.length];

        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = 1; i < piles.length; i++) {

            for (int j = 0; j < piles.length - i; j++) {

                dp[j][i] = Math.max(piles[j] - dp[j + 1][j + i], piles[j + i] - dp[j][j + i - 1]);
            }
        }

        return dp[0][piles.length - 1] > 0;
    }


    public static void main(String[] args) {
        System.out.println("结果：" + stoneGame(new int[]{10, 5, 7, 9}));
    }

}
