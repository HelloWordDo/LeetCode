package com.leetcode.string;

import java.util.HashMap;

public class RomanToInt_13 {

    public static int romanToInt(String s) {

        HashMap<String, Integer> map = new HashMap(7);

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int length = s.length();

        int total = 0;
        for (int i = 0; i < length; i++) {

            char roma = s.charAt(i);
            int number = map.get(Character.toString(roma));

            if (i + 1 < length) {
                char romaNext = s.charAt(i + 1);
                if ("I".equals(Character.toString(roma)) && "V".equals(Character.toString(romaNext)) ||
                        "I".equals(Character.toString(roma)) && "X".equals(Character.toString(romaNext))) {
                    int a = map.get(Character.toString(roma));
                    int b = map.get(Character.toString(romaNext));

                    number = b - a;
                    ++i;
                }
                if ("X".equals(Character.toString(roma)) && "L".equals(Character.toString(romaNext)) ||
                        "X".equals(Character.toString(roma)) && "C".equals(Character.toString(romaNext))) {

                    int a = map.get(Character.toString(roma));
                    int b = map.get(Character.toString(romaNext));

                    number = b - a;
                    ++i;
                }
                if ("C".equals(Character.toString(roma)) && "D".equals(Character.toString(romaNext)) ||
                        "C".equals(Character.toString(roma)) && "M".equals(Character.toString(romaNext))) {

                    int a = map.get(Character.toString(roma));
                    int b = map.get(Character.toString(romaNext));

                    number = b - a;
                    ++i;
                }
            }


            total = total + number;
        }
        return total;
    }

    public static void main(String[] args) {

        int num = romanToInt("MCMXCIV");
        System.out.println(num);
    }
}
