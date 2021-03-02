package com.leetcode.tree.simple;

import com.leetcode.tree.Serialize;
import com.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST_108 {

    public static TreeNode sortedArrayToBST(int[] nums) {

        return bst(null, nums);
    }

    public static TreeNode bst(TreeNode node, int[] nums) {

        if (nums.length == 0) {
            return node;
        }

        int mid = nums.length / 2;

        if (node == null) {
            node = new TreeNode(nums[mid]);

            int[] left = Arrays.copyOfRange(nums, 0, mid);
            int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);

            node.left = bst(node.left, left);
            node.right = bst(node.right, right);
        }

        return node;
    }


    public static void main(String[] args) {

        TreeNode node = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});

        System.out.println("结果：" + Serialize.serialize(node));
    }
}
