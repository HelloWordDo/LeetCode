package com.leetcode.base;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 寻找一个数
     *
     * @param nums
     * @param target
     * @return
     */
    public int base(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 最左侧边界二分查找(左闭右闭) [left,nums.length-1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int leftSearch1(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    /**
     * 最右侧边界二分查找(左闭右闭) [left,nums.length-1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int rightSearch1(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();

        int a = search.base(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2);
        System.out.println("二分查找结果下标:[" + a + "]");

        int b = search.leftSearch1(new int[]{1, 2, 2, 2, 2, 6, 7, 8, 9}, 2);
        System.out.println("二分最左侧边界下标:[" + b + "]");

        int c = search.rightSearch1(new int[]{1, 2, 2, 2, 2, 6, 7, 8, 9}, 2);
        System.out.println("二分最右侧边界下标:[" + c + "]");
    }
}
