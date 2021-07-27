package com.sort;

/**
 * 插入排序
 */
public class InsertSort {

    private void sort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            int cur = nums[i + 1];
            int pre = i;
            while (pre >= 0 && cur < nums[pre]) {

                nums[pre + 1] = nums[pre];
                pre--;
            }

            nums[pre + 1] = cur;
        }
    }

    public static void main(String[] args) {

        InsertSort sort = new InsertSort();
        int[] nums = new int[]{4, 1, 6, 3, 2, 5};
        sort.sort(nums);

        System.out.println(nums);
    }
}
