package com.leetcode.greedy.simple;

/**
 * 860. 柠檬水找零
 */
public class LemonadeChange_860 {

    public static boolean lemonadeChange(int[] bills) {

        int bill5 = 0;
        int bill10 = 0;
        for (int i = 0; i < bills.length; i++) {

            switch (bills[i]) {
                case 5:
                    bill5++;
                    break;

                case 10:
                    if (bill5 == 0) {
                        return false;
                    }
                    bill5--;
                    bill10++;
                    break;

                case 20:

                    if (bill10 > 0 && bill5 > 0) {
                        bill5--;
                        bill10--;
                    } else if (bill5 > 2) {
                        bill5 -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
    }
}
