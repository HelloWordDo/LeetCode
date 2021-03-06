package com.leetcode.dynamic.programming.middle;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class LongestValidParentheses_32 {

    public int longestValidParentheses(String s) {

        int res = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        LongestValidParentheses_32 method = new LongestValidParentheses_32();
//        System.out.println(method.longestValidParentheses("(()"));
//        System.out.println(method.longestValidParentheses(")()())"));

        System.out.println(method.longestValidParentheses("))(()"));
    }
}
