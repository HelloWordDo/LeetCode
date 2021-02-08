package com.leetcode.string;

import java.util.Stack;

public class IsValid_20 {

    public static boolean isValid(String s) {

        int length = s.length();

        Stack<String> stack = new Stack<>();

        if (s.equals("")) return true;
        char cc = s.charAt(0);

        stack.push(Character.toString(cc));


        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);

            if (stack.empty()) {
                stack.push(Character.toString(c));
                continue;
            }
            String top = stack.peek();

            if (top.equals(getValue(Character.toString(c)))) {
                stack.pop();
            } else {
                stack.push(Character.toString(c));
            }
        }

        if (stack.empty())
            return true;
        else
            return false;
    }


    public static String getValue(String s) {
        switch (s) {
            case "{":
                return "}";

            case "(":
                return ")";

            case "[":
                return "]";

            case "}":
                return "{";

            case ")":
                return "(";

            case "]":
                return "[";
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(isValid(""));
//        输入: "([)]"
//        输出: false

    }
}
