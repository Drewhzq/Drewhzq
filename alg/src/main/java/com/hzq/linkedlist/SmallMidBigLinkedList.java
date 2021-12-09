package com.hzq.linkedlist;

/**
 * 给定链表和指定值，返回一个新链表
 * 满足小于指定值 等于指定值 大于指定值
 * <p>
 * 方法1；转换为数组，利用数组做partition
 * 方法2：构建六个指针 空间复杂度O(1)
 */
public class SmallMidBigLinkedList {

    /**
     * 单向链表Node
     */
    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static Node getSmallMidBig(Node head, int value) {
        if (head == null) {
            throw new RuntimeException("head is null");
        }

        //小于部分的头尾指针
        Node sHead = null;
        Node sTail = null;

        //等于部分的头尾指针
        Node eHead = null;
        Node eTail = null;

        //大于部分的头尾指针

        Node lHead = null;
        Node lTail = null;
        Node next = null;
        while (head != null) {
            next  = head.next;

            //将该节点的next指针置为null,避免出现环
            head.next = null;
            //小于指定值
            if (head.value < value) {
                if (sTail == null) {
                    sHead = head;
                    sTail = head;
                } else {
                    sTail.next = head;
                    sTail = head;
                }
            }
            //等于指定值
            else if (head.value == value) {
                if (eTail == null) {
                    eHead = head;
                    eTail = head;
                } else {

                    eTail.next = head;
                    eTail = head;
                }
            }
            //大于指定值
            else {
                if (lTail == null) {
                    lTail = head;
                    lHead = head;
                } else {

                    lTail.next = head;
                    lTail = head;
                }
            }
            head = next;
        }

        if(sTail != null)
        {
            sTail.next = (eTail == null ? lHead : eHead);
        }

        if(eTail != null)
        {
            eTail.next = lHead;
        }

        return sHead == null ? (eHead == null ? lHead : eHead) :sHead;

    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        Node node4 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(3);
        Node node7 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node smallMidBig = getSmallMidBig(node1, 3);

        while(smallMidBig != null)
        {
            System.out.println(smallMidBig.value);
            smallMidBig = smallMidBig.next;
        }
    }
}
