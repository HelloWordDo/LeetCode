package com.leetcode.string;

/**
 * 外观数列
 */
public class CountAndSay_38 {


    public static String countAndSay(int n) {

        String countSay = "1";
        if (n == 1) {
            countSay = "1";
        }

        for (int i = 2; i <= n; i++) {

            StringBuffer sb = new StringBuffer();
            int length = countSay.length();
            int count = 1;
            String current = "";
            String next;
            for (int j = 0; j < length; j++) {

                current = Character.toString(countSay.charAt(j));

                for (int m = j + 1; m < length; m++) {

                    next = Character.toString(countSay.charAt(m));
                    if (next.equals(current)) {
                        ++count;
                    } else {
                        sb.append(count).append(current);
                        j = m;
                        current = Character.toString(countSay.charAt(j));
                        count = 1;
                    }
                }
            }
            //当m超过长度时候，记录j的当前count和current
            sb.append(count).append(current);
            countSay = sb.toString();
            System.out.println(countSay);
        }
        return countSay;
    }

    //            1.     1
//            2.     11
//            3.     21
//            4.     1211
//            5.     111221
//             6. 312211
    public static void main(String[] args) {
        System.out.println("结果：" + countAndSay(7));
    }
}
