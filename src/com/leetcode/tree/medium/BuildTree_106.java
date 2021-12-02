package com.leetcode.tree.medium;

import com.leetcode.tree.Serialize;
import com.leetcode.tree.TreeNode;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree_106 {

    HashMap<Integer, Integer> indexMap = new HashMap();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        TreeNode node = buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return node;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {

        if (inL > inR) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postR]);

        int rootIndex = indexMap.get(postorder[postR]);

        int rightSize = inR - rootIndex;

        node.left = buildTree(inorder, postorder, inL, rootIndex - 1, postL, postR - rightSize - 1);
        node.right = buildTree(inorder, postorder, rootIndex + 1, inR, postR - rightSize, postR - 1);

        return node;
    }

    public static void main(String[] args) {

        BuildTree_106 method = new BuildTree_106();

//        TreeNode node = method.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TreeNode node = method.buildTree(new int[]{10, 11, 9, 3, 7, 20, 13, 6}, new int[]{11, 10, 9, 7, 13, 6, 20, 3});
        System.out.println(Serialize.serialize(node));
    }
}
