package com.leetcode.array.simple;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class Merge_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = nums1.length - 1, j = n - 1, k = m - 1;
        int cur;
        while (k >= 0 || j >= 0) {
            if (k == -1) {
                cur = nums2[j--];
            } else if (j == -1) {
                cur = nums1[k--];
            } else if (nums1[k] > nums2[j]) {
                cur = nums1[k--];
            } else {
                cur = nums2[j--];
            }

            nums1[i--] = cur;
        }

        System.out.println(nums1);
    }


    public static void main(String[] args) {

        Merge_88 method = new Merge_88();
        method.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

    }
}
