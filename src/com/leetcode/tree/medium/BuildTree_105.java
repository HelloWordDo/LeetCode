package com.leetcode.tree.medium;

import com.leetcode.tree.Serialize;
import com.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree_105 {

    int pre = 0;
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        indexMap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        TreeNode treeNode = buildTree(preorder, inorder, pre, inorder.length, 0, inorder.length);

        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preL, int in, int inL, int inR) {

        if (inL == in) {
            --pre;
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre]);

        int order = indexMap.get(preorder[pre]);

        inR = in;
        in = order;

//        for (int i = inL; i < in; i++) {
//            if (inorder[i] == preorder[pre]) {
//                inR = in;
//                in = i;
//                break;
//            }
//        }

        System.out.println(in + " " + inL + " " + inR + " " + pre);

        node.left = buildTree(preorder, inorder, ++pre, in, inL, inR);
        node.right = buildTree(preorder, inorder, ++pre, inR, in + 1, inR);
        return node;
    }

    public static void main(String[] args) {

        BuildTree_105 method = new BuildTree_105();
//        TreeNode node = method.buildTree(new int[]{3, 9, 10, 11, 20, 15, 17}, new int[]{10, 9, 11, 3, 15, 20, 17});
//        TreeNode node = method.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
//        TreeNode node = method
//                .buildTree(new int[]{3, 9, 10, 11, 20, 15, 17, 19}, new int[]{10, 11, 9, 3, 15, 20, 17, 19});

//        TreeNode node = method.buildTree(new int[]{3, 20}, new int[]{3, 20});

        TreeNode node = method.buildTree(new int[]{3, 9, 11, 20, 17}, new int[]{9, 11, 3, 17, 20});
        System.out.println(Serialize.serialize(node));
    }

}
