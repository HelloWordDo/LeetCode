package com.leetcode.array.hard;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class FindMedianSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] num = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {

            int a = nums1[i];
            int b = nums2[j];

            if (a < b) {

                num[k] = a;
                i++;
            } else if (a > b) {
                num[k] = b;
                j++;
            } else if (a == b) {

                num[k] = a;
                num[k + 1] = b;
                k++;
                i++;
                j++;
            }
            k++;
        }

        if (i < nums1.length) {
            for (int l = i; l < nums1.length; l++) {
                num[k] = nums1[l];
                k++;
            }
        }

        if (j < nums2.length) {
            for (int l = j; l < nums2.length; l++) {
                num[k] = nums2[l];
                k++;
            }
        }

        int n = num.length % 2;
        double res=0;
        if (n == 0) {
            res = (double)(num[num.length / 2] + num[num.length / 2 - 1]) / 2;

        } else {
            res = num[num.length / 2];
        }

        return res;
    }

    public static void main(String[] args) {

        FindMedianSortedArrays_4 method = new FindMedianSortedArrays_4();
        System.out.println(method.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

    }
}
