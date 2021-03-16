package com.leetcode.math.middle;

/**
 * 33. 搜索旋转排序数组
 */
public class Search_33 {

    //二分查找
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            //后有序
            if (nums[left] > nums[mid]) {

                //后面找
                //nums[mid] < target <= nums[right]
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //前有序
            else {
                //前面找
                //nums[left] <= target < nums[mid]
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Search_33 method = new Search_33();
        System.out.println("结果：" + method.search(new int[]{3, 1}, 1));
    }
}
