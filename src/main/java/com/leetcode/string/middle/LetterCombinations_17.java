package com.leetcode.string.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinations_17 {


    //最终输出结果的list
    static List<String> res = new ArrayList<>();

    static String[] s = new String[]{"*", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        iterStr(digits, 0, new StringBuffer());
        return res;
    }

    public static void iterStr(String digits, int index, StringBuffer sb) {

        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char a = digits.charAt(index);

        int pos = a - '0';

        String str = s[pos];

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            sb.append(c);

            iterStr(digits, index + 1, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
