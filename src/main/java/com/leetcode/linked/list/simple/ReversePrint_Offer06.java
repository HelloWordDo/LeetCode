package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class ReversePrint_Offer06 {

    public static int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[0];
        }

        ListNode node = head;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        int[] nums = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            nums[i] = node.val;
            node = node.next;
        }

        return nums;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(5);
        ListNode n2 = n1;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(3);
        n2 = n2.next;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(1);

        reversePrint(n1);
    }
}
