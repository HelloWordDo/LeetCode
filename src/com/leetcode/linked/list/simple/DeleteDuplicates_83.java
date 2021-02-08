package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates_83 {


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode l = head;

        while (l != null && l.next != null) {

            if (l.val == l.next.val) {
                l.next = l.next.next;
            } else {
                l = l.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(4);

        deleteDuplicates(n1);
    }
}
