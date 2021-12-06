package com.hzq.linkedlist;

/**
 * 链表相关
 */
public class ReversalLinkedList {

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


    /**
     * 双向链表Node
     */
    static class DoubleNode {
        private int value;
        private DoubleNode next;
        private DoubleNode pre;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 翻转单向链表
     *
     * @param head
     * @return
     */
    public static Node reversalNode(Node head) {
        if (head == null) {
            throw new RuntimeException("head is null");
        }
        Node next = null;
        Node newHead = null;
        while (head != null) {
            next = head.next;

            head.next = newHead;
            newHead = head;

            head = next;

        }
        return newHead;
    }


    /**
     * 翻转双向链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reversalDoubleNode(DoubleNode head) {
        if (head == null) {
            throw new RuntimeException("head is null");
        }
        DoubleNode newHead = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            head.pre = next;
            newHead = head;
            head = next;

        }
        return newHead;
    }

    /**
     * 删除单向链表中的值
     *
     * @param head
     * @param value
     * @return
     */
    public static Node removeNode(Node head, int value) {
        //先找到链表中第一个不被删的节点作为头结点
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }

        Node cur = head;
        Node pre = head;
        while (cur != null) {

            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 利用双向链表实现双端队列
     */
    class MyDoubleQueue {
        private DoubleNode head;
        private DoubleNode tail;

        /**
         * 向队列头部添加元素
         *
         * @param value
         */
        public void addToHead(int value) {
            final DoubleNode node = new DoubleNode(value);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        /**
         * 向队列尾部添加元素
         */
        public void addToBottom(int value) {
            final DoubleNode node = new DoubleNode(value);
            if (head == null) {
                head = node;
                tail = node;
            } else {

                node.pre = tail;
                tail.next = node;
                tail = node;
            }
        }

        /**
         * 队列头部弹出一个元素
         */
        public Integer popFromHead() {
            Integer value = null;
            if (head == null) {
                return null;
            } else {
                value = head.value;
                head.next.pre = null;
                head = head.next;
            }
            return value;
        }


        public Integer popFromBottom() {
            Integer value = null;

            if (head == null) {
                return null;
            } else {
                value = tail.value;
                tail.pre.next = null;
                tail = tail.pre;
            }
            return value;
        }
    }

    public static void main(String[] args) {
        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        final Node node3 = new Node(3);
        final Node node4 = new Node(4);
        final Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node node = reversalNode(node1);
        while (node.next != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }


}
