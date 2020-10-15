package com.leetcode.greedy.simple;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class FindContentChildren_455 {


    public static int findContentChildren(int[] g, int[] s) {


        if (g == null || s == null) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {

            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }


        return gi;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + findContentChildren(new int[]{7, 1, 5, 3, 6, 4}, new int[]{7, 1, 5, 3, 6, 4}));
    }
}
