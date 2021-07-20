package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * <p>
 * 输入：S = "12345"
 * 输出：["12345"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class LetterCasePermutation_784 {

    List<String> res = new ArrayList();

    public List<String> letterCasePermutation(String s) {

        backtrack(s.toCharArray(), 0);
        return res;
    }

    public void backtrack(char[] c, int i) {

        if (i == c.length) {
            res.add(new String(c));
            return;
        }

        backtrack(c, i + 1);
        Character cc = c[i];
        if (Character.isLetter(cc)) {
            c[i] ^= 1 << 5;
            backtrack(c, i + 1);
        }
    }

    public static void main(String[] args) {

        LetterCasePermutation_784 method = new LetterCasePermutation_784();
        method.letterCasePermutation("a1b2");
    }
}
