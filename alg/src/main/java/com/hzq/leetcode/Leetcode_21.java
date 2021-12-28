package com.hzq.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Leetcode_21 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            cur = cur.next;
        }
        while(list1 != null)
        {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        while(list2 != null)
        {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        return newHead.next;
    }
}
