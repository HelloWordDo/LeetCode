package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 面试题 02.03. 删除中间节点==DeleteNode_237.java
 */
public class DeleteNode_0203 {

    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

}
