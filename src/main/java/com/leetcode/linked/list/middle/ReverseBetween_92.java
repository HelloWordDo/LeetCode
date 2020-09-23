package com.leetcode.linked.list.middle;

import com.leetcode.linked.list.ListNode;

/**
 * 92. 反转链表 II
 */
public class ReverseBetween_92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;

        ListNode n1 = node;
        ListNode n2 = n1;

        int count = 0;

        ListNode after = null;
        ListNode before = null;
        while (count <= n) {

            ++count;
            if (count < m) {

                n1 = n1.next;
                continue;
            }
            if (count == m) {
                n2 = n1.next;
                after = n1.next;
                continue;
            }
            ListNode temp = n2.next;
            n2.next = before;
            before = n2;
            n2 = temp;
        }

        n1.next = before;
        after.next = n2;

        return node.next;
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
        n2 = n2.next;
        n2.next = new ListNode(6);
        n2 = n2.next;
        n2.next = new ListNode(7);
        n2 = n2.next;
        n2.next = new ListNode(8);

        reverseBetween(n1, 2, 3);
    }
}
