package com.hzq.leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Leetcode_42 {

    public static int trap(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = leftMax[i - 1] > height[i] ? leftMax[i - 1] : height[i];
        }

        for (int j = height.length - 2; j >= 0; j--) {
            rightMax[j] = rightMax[j + 1] > height[j] ? rightMax[j + 1] : height[j];
        }

        int res = 0;
        for (int n = 0; n < height.length; n++) {
            res += Math.min(leftMax[n], rightMax[n]) - height[n];
        }
        return res;

    }

    public static int trap1(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 1;
        int right = height.length - 2;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int res = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                res += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(leftMax, height[left++]);
            }  else {
                res += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        trap1(new int[]{4,2,0,3,2,5});
    }
}
