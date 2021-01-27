package com.leetcode.string.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis_21 {

    static String s1 = "(";
    static String s2 = ")";

    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {

        if (n == 0) {
            return Collections.EMPTY_LIST;
        }

        int left = n, right = n;

        dfs(s1, left - 1, right);
        return res;
    }

    //深度优先遍历
    public static void dfs(String curentStr, int left, int right) {

        if (left == 0 && right == 0) {
            res.add(curentStr);
            return;
        }
        if (right < left) {
            return;
        }

        if (left > 0) {
            dfs(curentStr + s1, left - 1, right);
        }

        if (right > 0) {
            dfs(curentStr + s2, left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
