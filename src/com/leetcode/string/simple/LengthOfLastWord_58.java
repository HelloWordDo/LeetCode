package com.leetcode.string.simple;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用单个或多个连续的空格字符隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {

        String[] ss = s.split(" ");
        return ss.length == 0 ? 0 : ss[ss.length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord_58 method = new LengthOfLastWord_58();
//        System.out.println(method.lengthOfLastWord("Hello World"));
        System.out.println(method.lengthOfLastWord(" "));
    }
}
