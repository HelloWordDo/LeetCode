package com.leetcode.dynamic.programming.middle;

import java.util.Arrays;

/**
 * 646. 最长数对链
 */
public class FindLongestChain_646 {

    public static int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < pairs.length; i++) {

            for (int j = 0; j < i; j++) {

                if (pairs[i][0] > pairs[j][1]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int x : dp) {
            if (ans < x) {
                ans = x;
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        System.out.println(findLongestChain(new int[][]{{1, 2}, {5, 7}, {6, 9}, {3, 5}, {10, 11}}));
    }
}
