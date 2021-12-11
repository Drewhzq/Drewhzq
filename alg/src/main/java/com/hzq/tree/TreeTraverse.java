package com.hzq.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class TreeTraverse {

    /**
     * 递归前序遍历,打印每个节点
     *
     * @param root
     * @return
     */
    public static void preorderTraversal1(TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
    }

    /**
     * 非递归方法实现前序遍历 头 -> 左 ->右
     * 利用栈结构， head 先进栈，然后右子节点进栈，然后左子节点进栈
     *
     * @param root
     */
    public static List<TreeNode> preorderTraversal2(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            res.add(popNode);
            if (popNode.right != null) {
                stack.push(popNode.right);
            }
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
        }
        return res;
    }
}
