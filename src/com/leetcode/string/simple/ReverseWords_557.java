package com.leetcode.string.simple;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWords_557 {

    public String reverseWords(String s) {

        String[] sp = s.split(" ");

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sp.length; i++) {

            String ss = reverseString(sp[i]);

            sb.append(ss).append(" ");
        }
        return sb.toString().trim();
    }

    public String reverseString(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {

        ReverseWords_557 method = new ReverseWords_557();

        System.out.println(method.reverseWords("Let's take LeetCode contest"));
    }
}
