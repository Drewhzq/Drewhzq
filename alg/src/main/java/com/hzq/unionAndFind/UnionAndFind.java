package com.hzq.unionAndFind;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并查集
 */
public class UnionAndFind {

    static class Node<V> {
        V val;

        public Node(V val) {
            this.val = val;
        }
    }

    static class UnionSet<V> {
        //记录元素对应的节点Node
        private Map<V, Node> nodes;

        //记录节点对应的父节点
        private Map<Node, Node> parents;

        //记录父节点下的节点个数
        private Map<Node, Integer> sizeMap;

        /**
         * 构造方法,初始化方法
         */
        public UnionSet(List<V> list) {
            for (V v : list) {
                final Node node = new Node(v);
                nodes.put(v, node);
                //初始化父节点为自己
                parents.put(node, node);
                //父节点为自己，所以一个节点下面都有一个元素
                sizeMap.put(node, 1);
            }
        }

        /**
         * 是否是同一个父节点
         *
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }

            return findParent(a) == findParent(b);
        }


        /**
         * 找到指定元素的父节点
         *
         * @param v
         * @return
         */
        public Node findParent(V v) {

            final Stack<Node> path = new Stack<>();
            Node curNode = nodes.get(v);
            while(curNode != parents.get(curNode))
            {
                path.push(curNode);
                curNode = parents.get(curNode);
            }

            while(!path.isEmpty())
            {
                parents.put(path.pop(),curNode);
            }
            return curNode;
        }

        /**
         * 合并方法
         *
         * @param a
         * @param b
         */
        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            final Node aParent = findParent(a);
            final Node bParent = findParent(b);

            if (aParent != bParent) {
                if (sizeMap.get(aParent) > sizeMap.get(bParent)) {
                    parents.put(bParent, aParent);
                    sizeMap.put(aParent, sizeMap.get(aParent) + sizeMap.get(bParent));
                } else {

                    parents.put(aParent, bParent);
                    sizeMap.put(bParent, sizeMap.get(aParent) + sizeMap.get(bParent));
                }
                sizeMap.remove(bParent);
            }


        }
    }
}
