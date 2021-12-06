package com.hzq;

public class PrefixTree {

    public static class Node1
    {
        private int pass;

        private int end;

        private Node1[] nodo1;

        public Node1()
        {
            this.pass = 0;
            this.end = 0;
            this.nodo1 = new Node1[26];
        }
    }

    public static class TiesTree
    {
        Node1 root;

        public TiesTree()
        {
            root = new Node1();
        }


        /**
         * 插入方法
         */
        public void insertTree(String word)
        {
            if(word == null || word.isEmpty())
            {
                return;
            }
            Node1 node = root;
            final char[] strs = word.toCharArray();
            root.pass++;
            for(int i = 0; i< strs.length;i++)
            {
               int path = strs[i] - 'a';
               if(node.nodo1[path] == null)
               {
                   final Node1 pathNode = new Node1();
                    node.nodo1[path] = pathNode;
               }
               node = node.nodo1[path];
               node.pass++;
            }
            node.end++;
        }

        /**
         * search 方法
         * 返回前缀树中有多少个该字符串
         */
        public int search(String word)
        {
            if(word == null || word.isEmpty())
            {
                return 0;
            }
            final char[] strs = word.toCharArray();

            Node1 node = root;
            for(int i = 0; i < strs.length;i++)
            {
                int path = strs[i] - 'a';
                if(node.nodo1[path] == null)
                {
                    return 0;
                }
                node = node.nodo1[path];
            }
            return node.end;
        }

        /**
         * 返回前缀树种有多少个前缀是该字符串的个数
         */
        public int searchPrefix(String word)
        {
            if(word == null || word.isEmpty())
            {
                return 0;
            }
            Node1 node = root;
            final char[] strs = word.toCharArray();
            for(int i = 0;i<strs.length;i++)
            {
                int path = strs[i] - 'a';
                if(node.nodo1[path] == null)
                {
                    return 0;
                }
                node = node.nodo1[path];
            }

            return node.pass;
        }

        /**
         * 删除前缀树中该字符串
         */
        public void delete(String word)
        {
            if(word == null || word.isEmpty())
            {
                return;
            }
            final char[] strs = word.toCharArray();
            Node1 node = root;
            node.pass--;
            for(int i = 0;i<strs.length;i++)
            {
                int path = strs[i] - 'a';
                if(--node.nodo1[path].pass == 0)
                {
                    node.nodo1[path] = null;
                    return;
                }
                node = node.nodo1[path];
            }
            node.end--;


        }


    }



    public static void main(String[] args) {
        final TiesTree tree = new TiesTree();
        tree.insertTree("abc");
        tree.insertTree("ac");
        tree.insertTree("bcv");
        tree.insertTree("avc");
        tree.insertTree("nbc");
        tree.insertTree("hbc");
        tree.insertTree("abc");
        final int a = tree.search("abc");
        final int b= tree.searchPrefix("a");
        System.out.println(b);
    }



}
