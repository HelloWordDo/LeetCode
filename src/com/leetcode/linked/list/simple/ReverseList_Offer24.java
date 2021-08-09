package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class ReverseList_Offer24 {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode next = head.next;

        pre.next = null;
        while (next != null) {

            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }

        return pre;
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


        ReverseList_Offer24 method = new ReverseList_Offer24();
        method.reverseList(n1);
    }


}
