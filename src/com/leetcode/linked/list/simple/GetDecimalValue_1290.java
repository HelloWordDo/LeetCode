package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 1290. 二进制链表转整数
 */
public class GetDecimalValue_1290 {

    public static int getDecimalValue(ListNode head) {

        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return head.val;
        }

        String binary = "";
        while (head != null) {

            binary += head.val;
            head = head.next;
        }
        int b = Integer.parseInt(binary, 2);
        return b;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(0);
        ListNode n2 = n1;
        n2.next = new ListNode(1);
        n2 = n2.next;
        n2.next = new ListNode(1);
        n2 = n2.next;
        n2.next = new ListNode(1);
        n2 = n2.next;
        n2.next = new ListNode(1);

        getDecimalValue(n1);
    }
}
