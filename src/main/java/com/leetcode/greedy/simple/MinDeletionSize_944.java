package com.leetcode.greedy.simple;

/**
 * 944. 删列造序
 */
public class MinDeletionSize_944 {

    public static int minDeletionSize(String[] A) {

        int ans = 0;
        int len1 = A.length;
        int len2 = A[0].length();

        for (int i = 0; i < len2; i++) {

            for (int j = 0; j < len1 - 1; j++) {

                String s = A[j];

                char c1 = A[j].charAt(i);
                char c2 = A[j + 1].charAt(i);

                if (c1 > c2) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + minDeletionSize(new String[]{"cba", "daf", "ghi"}));
    }
}
