package com.hzq.leetcode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Leetcode_19 {

    class ListNode {
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

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//
//        if (head == null) {
//            return null;
//        }
//        ListNode fast = head;
//        ListNode slow = head;
//        ListNode next = null;
//        while (fast != null) {
//            if (n != 0) {
//                next = fast.next;
//                fast = next;
//                n--;
//            } else {
//                next = fast.next;
//                slow = head.next;
//
//                if (fast.next == null) {
//                    slow.next = slow.next.next;
//                    break;
//                }
//                fast = next;
//            }
//        }
//        return head;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode per = null;

        while (cur != null) {
            if (n == 0) {
                per = head;
            } else if (n < 0) {
                per = per.next;
            }
            cur = cur.next;
            n--;
        }

        if (n > 0) {
            return head;
        }


        if (per == null) {
            return head.next;
        } else {
            per.next = per.next.next;
            return head;
        }

    }
}
