package com.hzq.leetcode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 */
public class Leetcode_83 {

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

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;

        ListNode next = head.next;

        while (next != null) {
            if (next.val == cur.val) {
                next = next.next;
                continue;
            } else {
                cur.next = next.next;
                cur = cur.next;
                next = next.next;
            }
            if(next == null)
            {
                cur.next = null;
            }
        }
        return head;
    }
}
