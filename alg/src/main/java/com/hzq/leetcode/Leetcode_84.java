package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Leetcode_84 {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[][] res = new int[heights.length][2];
        Stack<List<Integer>> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek().get(0)] > heights[i]) {

                final List<Integer> pop = stack.pop();

                int lessLeftIndex = stack.isEmpty() ? -1 : stack.peek().get(pop.size() - 1);

                for(int index : pop)
                {
                    res[index][0] = lessLeftIndex;
                    res[index][1] = i;
                }

            }

            if (!stack.isEmpty() && heights[stack.peek().get(0)] == heights[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.add(list);
            }

        }

        while(!stack.isEmpty())
        {
            List<Integer> restList = stack.pop();

            int lessLeftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for(int index : restList)
            {
                res[index][0] = lessLeftIndex;
                res[index][1] = -1;
            }

        }

        //计算面积
        int maxRes = 0;
        for(int i = 0; i < res.length;i++)
        {
            //高为数组值
            int high = heights[i];

            //宽

            int a = res[i][0];
            int b = res[i][1] == -1 ? heights.length : res[i][1];

            int width = b - a == 0 ? 1 : b - a - 1;
            maxRes = Math.max(maxRes,high * width);

        }
        return maxRes;

    }

    public static int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {

                final int pop = stack.pop();

                int lessLeftIndex = stack.isEmpty() ? -1 : stack.peek();

                res = Math.max(res, heights[i] * (i - lessLeftIndex - 1));

            }

        }

        while(!stack.isEmpty())
        {
            int restList = stack.pop();

            int lessLeftIndex = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, heights[restList] *(heights.length - lessLeftIndex - 1));

        }

        return res;

    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{1,2,2});
    }
}
