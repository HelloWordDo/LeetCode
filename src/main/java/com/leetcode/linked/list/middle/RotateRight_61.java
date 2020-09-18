package com.leetcode.linked.list.middle;

import com.leetcode.linked.list.ListNode;

/**
 * 61. 旋转链表
 */
public class RotateRight_61 {

    public static ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        int t = k % count;
        ListNode start = head;

        for (int i = 0; i < t; i++) {

            ListNode end1 = start;
            while (end1.next.next != null) {

                end1 = end1.next;
            }

            ListNode end2 = end1.next;
            end1.next = null;
            end2.next = start;
            start = end2;
        }

        return start;
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(3);
        n2 = n2.next;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(5);

        rotateRight(n1, 2);
    }
}
