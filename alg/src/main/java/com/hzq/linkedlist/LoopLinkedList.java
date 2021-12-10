package com.hzq.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。
 * 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/c32eOV
 */
public class LoopLinkedList {

    private static class Node
    {
        int value;
        Node next;
        Node random;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 利用hash表
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head)
    {
        if(head == null)
        {
            return null;
        }
        Set<Node> set = new HashSet<>();
        Node next = head;
        while(next != null)
        {
            if(set.contains(next))
            {
                return next;
            }
            set.add(next);
            next = next.next;
        }
        return null;

    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static Node getLoopNode1(Node head)
    {
        if(head == null || head.next == null || head.next.next == null)
        {
            return null;
        }
        //fast
        Node fast = head.next.next;
        //slow
        Node slow = head.next;

        while(fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //跳出循环代表有环，让fast重新指向head
        fast = head;

        while (fast != slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }

    public static void main(String[] args) {
        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        node1.next = node2;
        node2.next = node1;

        final Node loopNode = getLoopNode1(node1);
        System.out.println(loopNode.value);

    }
}
