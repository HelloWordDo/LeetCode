package com.leetcode.linked.list.middle;

import com.leetcode.linked.list.ListNode;

import java.util.Stack;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Reorder_List_143 {

    public void reorderList(ListNode head) {

        Stack<ListNode> stack = new Stack();
        ListNode node = head;

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode a = head;
        ListNode p = head;
        ListNode b = stack.pop();

        while (a != b && a.next != b) {

            if (p != a) {
                p.next = a;
                p = p.next;
            }

            a = a.next;
            p.next = b;

            b = stack.pop();
            p = p.next;
            b.next = null;
        }

        if (p != a) {
            if (a == b) {
                a.next = null;
            } else {
                a.next = b;
            }
            p.next = a;
        }
        System.out.println(head);
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);

        ListNode n = node;
        for (int i = 2; i < 4; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        Reorder_List_143 method = new Reorder_List_143();
        method.reorderList(n);
    }

}
