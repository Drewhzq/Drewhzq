package com.hzq.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_2 {

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

    /**
     * 利用队列
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Deque<ListNode> stack1 = new LinkedList();
        Deque<ListNode> stack2 = new LinkedList();

        while (l1 != null) {
            stack1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2);
            l2 = l2.next;
        }
        int bit = 0;
        Deque<Integer> res = new LinkedList<>();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int count = stack1.poll().val + stack2.poll().val + bit;
            if (count >= 10) {
                res.add(count % 10);
                bit = count / 10;
            } else {
                res.add(count);
                bit = 0;
            }
        }
        while (!stack1.isEmpty()) {
            int num = stack1.poll().val + bit;
            if (num >= 10) {
                res.add(num % 10);
                bit = num / 10;
            } else {
                res.add(num);
                bit = 0;
            }

        }
        while (!stack2.isEmpty()) {
            int num = stack2.poll().val + bit;
            if (num >= 10) {
                res.add(num % 10);
                bit = num / 10;
            } else {
                res.add(num);
                bit = 0;
            }
        }
        if (bit != 0) {
            res.add(bit);
        }
        ListNode head = new ListNode(res.poll());
        ListNode cur = head;
        while (!res.isEmpty()) {
            cur.next = new ListNode(res.poll());
            cur = cur.next;
        }
        return head;
    }
}
