package com.hzq.linkedlist;

/**
 * 寻找链表中点
 *
 */
public class MidOfLinkedList {

    private static class Node
    {
        int value;
        Node next;
        public Node(){}
    }

    /**
     *  * 奇数返回中间的
     *  * 偶数返回上中点
     * @return
     */
    public static Node searchUpMidOfNodeList(Node head)
    {
        if(head == null ||head.next == null || head.next.next == null)
        {
            return head;
        }
        Node fast = head.next.next;
        Node slow = head.next;

        while(fast.next != null || fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     *  * 奇数返回中间的
     *  * 偶数返回上中点
     * @return
     */
    public static Node searchDownMidOfNodeList(Node head)
    {
        if(head == null ||head.next == null)
        {
            return head;
        }
        Node fast = head.next;
        Node slow = head.next;

        while(fast.next != null || fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
