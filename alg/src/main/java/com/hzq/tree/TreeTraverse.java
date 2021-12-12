package com.hzq.tree;

import java.util.*;

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

    /**
     * 递归实现后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        posProcess(res, root);
        return res;
    }

    /**
     * 非递归方式实现后序遍历  左 -> 右 -> 头 利用栈结构
     * 头节点先进栈，然后进右节点，最后进左节点 ，然后将让这个栈pop
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> helpStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            helpStack.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }

        }
        while (!helpStack.isEmpty()) {
            res.add(helpStack.pop().val);
        }
        return res;
    }

    /**
     * 非递归实现，不借助辅助栈，进一步压缩空间复杂度
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode flag = root;
        TreeNode h = null;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            h = stack.peek();
            //头结点的左子树全入栈
            if (h.left != null && h.left != flag && h.right != flag) {
                stack.push(h.left);
            } else if (h.right != null && h.right != flag) {
                stack.push(h.right);
            } else {
                TreeNode pop = stack.pop();
                //flag记录pop出来的是左子节点还是右子节点
                //若pop出来是左子节点，则继续去处理他的右子节点
                //若pop出来的是右子节点，则代表该右子节点的父节点这颗子树已处理完，直接继续pop栈
                //按照这种顺序，实现 左 -- 右 ---头遍历
                flag = pop;
                res.add(pop.val);
            }

        }
        return res;
    }


    /**
     * 二叉树的中序遍历 递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        return inProcess(res, root);

    }


    /**
     * 二叉树中序遍历非递归方式
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode leftNode = root;
        while (leftNode != null || !stack.isEmpty()) {
            //先将所有左边子树节点入栈
            if (leftNode != null) {
                stack.push(leftNode);
                leftNode = leftNode.left;
            } else {
                //该节点的所有左边子树节点装完了，pop头结点，返回右子树
                TreeNode pop = stack.pop();
                res.add(pop.val);
                leftNode = pop.right;
            }
        }
        return res;

    }

    /**
     * 宽度优先遍历
     * 利用队列
     *
     * @return
     */
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            res.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }

        }
        return res;
    }

    /**
     * 二叉树的最大宽度
     * 利用map实现
     *
     * @param root
     * @return
     */
    public static int maxWidthBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //记录树节点位于二叉树的哪一层上
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root,1);
        //记录当前节点的层级
        int curLevel = 1;
        //记录当前层有多少节点
        int curTreeNodes = 0;
        //记录节点数最大的层有多少节点
        int max = 0;

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int curNodeLevel = levelMap.get(curNode);
            if (curNode.left != null) {
                queue.add(curNode.left);
                levelMap.put(curNode.left, curLevel + 1);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                levelMap.put(curNode.right, curLevel + 1);
            }

            if (curNodeLevel == curLevel) {
                curTreeNodes++;
            } else {
                max = Math.max(max, curTreeNodes);
                curTreeNodes = 1;
                curLevel = curNodeLevel;
            }
        }
        return Math.max(max, curTreeNodes);
    }

    /**
     * 二叉树的最大宽度
     * 空间复杂度进一步压缩
     * @param root
     * @return
     */
    public static int maxWidthBinaryTree1(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curEnd = root;
        TreeNode nexEnd = null;
        int curLevelNodes = 0;
        int max = 0;
        while(!queue.isEmpty())
        {
            TreeNode curNode = queue.poll();
            if(curNode.left!=null)
            {
                queue.add(curNode.left);
                nexEnd = curNode.left;
            }
            if(curNode.right != null)
            {
                queue.add(curNode.right);
                nexEnd = curNode.right;
            }
            curLevelNodes++;
            if(curEnd == curNode)
            {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nexEnd;
            }
        }

        return max;
    }

    /**
     * 先序方式序列化二叉树
     * @param root
     * @return
     */
    public static String serializeTreeNode(TreeNode root)
    {
        List<String> res = new ArrayList<>();
        if(root == null)
        {
            return "";
        }
        serializeProcess(root, res);
        return res.toString();
    }

    /**
     * 宽度遍历方式序列化二叉树
     * @param root
     * @return
     */
    public static String serializeTreeNode1(TreeNode root) {
        if(root == null)
        {
            return "";
        }
        List<String> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode cur = queue.poll();
            if(cur == null)
            {
                list.add(null);
                continue;
            }
            list.add(String.valueOf(cur.val));
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return list.toString();
    }

    /**
     * 宽度遍历方式反序列化二叉树
     * @return
     */
    public static TreeNode deserializeTreeNode1(String data)
    {
        if(data == null)
        {
            return null;
        }
        data = data.replace('[',' ').replace(']',' ').trim();
        Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        Deque<TreeNode> treeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
        treeQueue.add(root);
        while(!treeQueue.isEmpty())
        {
            TreeNode cur = treeQueue.poll();
            String left = queue.poll();
            cur.left = left.trim().equals("null") ? null : new TreeNode(Integer.valueOf(left.trim()));
            String right = queue.poll();
            cur.right = right.trim().equals("null") ? null : new TreeNode(Integer.valueOf(right.trim()));
            if(cur.left != null)
            {
                treeQueue.add(cur.left);
            }
            if(cur.right != null)
            {
                treeQueue.add(cur.right);
            }

        }
        return root;
    }
    /**
     * 先序方式反序列化二叉树
     * @param treeNode
     * @return
     */
    public static TreeNode deserializeTreeNode(String treeNode)
    {
        if(treeNode == null || treeNode.isEmpty())
        {
            return null;
        }
        treeNode = treeNode.replace('[', ' ').replace(']', ' ');
        treeNode = treeNode.trim();
        final String[] split = treeNode.split(",");
        final List<String> list = Arrays.asList(split);
        Deque<String> queue = new LinkedList<>(list);
        final TreeNode root = buildTreeNode(queue);
        return root;
    }

    private static TreeNode buildTreeNode(Deque<String> queue) {
        final String poll = queue.poll();
        if("null".equals(poll) || poll == null)
        {
            return null;
        }
        final TreeNode treeNode = new TreeNode(Integer.valueOf(poll));
        treeNode.left = buildTreeNode(queue);
        treeNode.right = buildTreeNode(queue);
        return treeNode;
    }

    private static void serializeProcess(TreeNode root, List<String> res)
    {
        if(root == null)
        {
            res.add(null);
            return;
        }
        res.add(String.valueOf(root.val));
        serializeProcess(root.left,res);
        serializeProcess(root.right,res);

    }

    private List<Integer> inProcess(List<Integer> res, TreeNode root) {
        if (root == null) {
            return res;
        }
        inProcess(res, root.left);
        res.add(root.val);
        inProcess(res, root.right);
        return res;
    }

    private void posProcess(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        posProcess(res, root.left);
        posProcess(res, root.right);
        res.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.right = node2;
        root.left = node1;
//        node1.left = node3;
//        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        String str = "[1, 2, 3, null, null, 6, 7, null, null, null, null]";
        System.out.println(deserializeTreeNode1(str));

    }

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层序遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static List<List<Integer>> maxWidthBinaryTree2(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //记录树节点位于二叉树的哪一层上
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root,1);
        //记录当前节点的层级
        int curLevel = 1;
        List<Integer> curLevelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int curNodeLevel = levelMap.get(curNode);
            if (curNode.left != null) {
                queue.add(curNode.left);
                levelMap.put(curNode.left, curNodeLevel + 1);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                levelMap.put(curNode.right, curNodeLevel + 1);
            }

            if (curNodeLevel == curLevel) {
                curLevelList.add(curNode.val);
            } else {
                res.add(curLevelList);
                curLevelList = new ArrayList<>();
                curLevelList.add(curNode.val);
                curLevel = curNodeLevel;
            }
        }
        res.add(curLevelList);
        return res;
    }
}
