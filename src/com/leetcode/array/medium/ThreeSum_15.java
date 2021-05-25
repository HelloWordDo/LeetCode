package com.leetcode.array.medium;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class ThreeSum_15 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            if (r - i < 2 || nums[i] > 0) {
                return res;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }

        return res;
    }


    /**
     * 回溯 超时。。。。
     *
     * @param list
     * @param nums
     * @param visited
     * @param count
     * @param index
     */
    void backTrack(LinkedList<Integer> list, int[] nums, boolean[] visited, int count, int index) {

        if (count == 0 && list.size() == 3) {
            List sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            if (res.contains(sorted)) {
                return;
            }
            res.add(sorted);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            int num = nums[i];
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            count += num;

            list.add(num);
            backTrack(list, nums, visited, count, ++i);

            list.removeLast();
            --i;
            visited[i] = false;
            count -= num;
        }
    }


    public static void main(String[] args) {
        ThreeSum_15 method = new ThreeSum_15();
//        List<List<Integer>> res = method
//                .threeSum(new int[]{34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49});

        List<List<Integer>> res = method.threeSum(new int[]{-1, 0, 1, 2, -1, 4});
        System.out.println(res);
    }
}
