package com.leetcode.string.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 */
public class Valid_Palindrome_125 {

    public boolean isPalindrome(String s) {

        if (s.trim().equals("")) {

            return true;
        }

        List<Character> list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isLowerCase(c) || Character.isUpperCase(c) || Character.isDigit(c)) {
                list.add(Character.toLowerCase(c));
            }
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {

            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {

        Valid_Palindrome_125 method = new Valid_Palindrome_125();
//        System.out.println(method.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(method.isPalindrome("ABba"));
        System.out.println(method.isPalindrome("0P"));
    }
}
