package com.hzq.leetcode;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 */
public class Leetcode_32 {


    /**
     * 正向遍历，反向遍历
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {

        if (s == null) {
            return -1;
        }
        char[] strs = s.toCharArray();
        //记录遍历时遇到的左右括号的个数
        int left = 0;
        int right = 0;
        int res = 0;
        //正向遍历
        for (int i = 0; i < strs.length; i++) {

            if (strs[i] == '(') {
                left++;
            } else {
                right++;
            }

            if (right > left) {
                left = 0;
                right = 0;
                continue;
            }
            if (left == right) {
                res = Math.max(res, left + right);
            }
        }
        //反向遍历
        left = 0;
        right = 0;
        for (int i = strs.length - 1; i >= 0; i--) {

            if (strs[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
            if (left == right) {
                res = Math.max(res, left + right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        longestValidParentheses("()(()");
    }
}
