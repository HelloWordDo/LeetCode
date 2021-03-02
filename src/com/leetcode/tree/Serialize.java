package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树序列化
 */
public class Serialize {

    public static String SEP = ",";
    public static String NULL = "#";

    /**
     * 层序遍历
     * 将二叉树序列化为字符串
     *
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入队列!
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            /* 层级遍历代码位置 */
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            /*****************/

            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }
}
