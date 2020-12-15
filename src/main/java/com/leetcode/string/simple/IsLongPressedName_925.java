package com.leetcode.string.simple;

/**
 * 925. 长按键入
 */
public class IsLongPressedName_925 {

    public static boolean isLongPressedName(String name, String typed) {

        int lenN = name.length();
        int lenT = typed.length();

        int i = 0, j = 0;

        while (j < lenT) {

            if (i < lenN && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == lenN;
    }


    public static void main(String[] args) {
        System.out.println(isLongPressedName("assaeedn", "ssaaeeddn"));
    }
}