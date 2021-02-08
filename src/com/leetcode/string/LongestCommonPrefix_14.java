package com.leetcode.string;

public class LongestCommonPrefix_14 {


    public static String longestCommonPrefix(String[] strs) {

        int size = strs.length;

        String commonPrefix = "";
        if (size == 0) {
            return commonPrefix;
        }
        int minLength = strs[0].length();
        for (int i = 1; i < size; i++) {

            String s = strs[i];
            if (minLength > s.length()) {
                minLength = s.length();
            }
        }
        System.out.println("minLength:" + minLength);

        for (int m = 0; m < minLength; m++) {

            String s = strs[0];
            char currentText = s.charAt(m);

            for (int n = 1; n < size; n++) {

                String ss = strs[n];
                if (currentText != ss.charAt(m)) {
                    return commonPrefix;
                }
            }

            commonPrefix = commonPrefix + currentText;
        }

        return commonPrefix;
    }

    public static String longestCommonPrefix2(String[] strs) {

        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;

    }

    public static void main(String[] args) {

        System.out.println("commonPrefix：" + longestCommonPrefix2(new String[]{"flower","fleet","flout"}));
    }
}
