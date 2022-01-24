package com.hzq.leetcode;

import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class Leetcode_85 {
    public static int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[] high = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    high[j]++;
                } else {
                    high[j] = 0;
                }
            }

           res = Math.max(res,getRowMax(high));
        }
        return res;
    }

    private static int getRowMax(int[] high) {

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < high.length; i++) {
            while (!stack.isEmpty() && high[stack.peek()] >= high[i]) {
                int pop = stack.pop();
                int lessLeftIndex = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, high[pop] * (i - lessLeftIndex - 1));
            }
            stack.add(i);
        }


        while (!stack.isEmpty()) {
            int pop = stack.pop();
            int lessLeftIndex = stack.isEmpty() ? -1 : stack.peek();

            res = Math.max(res, high[pop] * (high.length - lessLeftIndex - 1));

        }
        return res;

    }

}
