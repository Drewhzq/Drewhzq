package com.hzq.huawei;

/**
 * 树的序列化以及中序遍历
 *
 * a{b{d,e{g,h{,i}}},c{f}}
 */
public class Exam2 {

    static class TreeNode
    {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(char val) {
            this.val = val;
        }

        TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static String getRes(String str)
    {
        if(str == null || str.isEmpty())
        {
            return "";
        }
        return null;
    }

    //a{b{d,e{g,h{,i}}},c{f}}
    private static TreeNode constructTree(String str) {
        return null;
    }

    public static void main(String[] args) {

    }
}
