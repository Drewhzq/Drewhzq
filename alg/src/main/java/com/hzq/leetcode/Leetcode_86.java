package com.hzq.leetcode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_86 {

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

    public static ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode aHead = null;
        ListNode aCur = null;
        ListNode tailA = null;
        ListNode bHead = null;
        ListNode bCur = null;
        ListNode tailB = null;
        while (cur != null) {
            if (cur.val >= x) {
                if (bHead == null) {
                    bHead = cur;
                    bCur = bHead;
                } else {
                    bCur.next = cur;
                    bCur = bCur.next;
                }
                tailB = bCur;


            } else {
                if (aHead == null) {
                    aHead = cur;
                    aCur = aHead;
                } else {
                    aCur.next = cur;
                    aCur = aCur.next;
                }
                tailA = aCur;

            }
            cur = cur.next;
        }
        if(tailA != null)
        {
            tailA.next = bHead;
        }
        if(tailB != null)
        {
            tailB.next = null;
        }
        return aHead == null ? bHead : aHead;

    }
}
