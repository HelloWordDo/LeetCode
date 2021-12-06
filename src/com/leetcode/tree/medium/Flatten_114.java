package com.leetcode.tree.medium;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class Flatten_114 {

    TreeNode pre = null;

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten(root.right);

        flatten(root.left);
        root.right = pre;
        pre = root;
        root.left = null;
    }

    public static void main(String[] args) {

        Flatten_114 method = new Flatten_114();

//        TreeNode root = Deserialize.LevelOrderDeserialize("1,2,5,3,4,#,6");
        TreeNode root = Deserialize.LevelOrderDeserialize("1,2,5,3,4,#,6,#,#,7,#,#,#");
        method.flatten(root);

        System.out.println(root);
    }
}
