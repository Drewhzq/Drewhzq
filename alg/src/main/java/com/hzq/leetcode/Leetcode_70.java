package com.hzq.leetcode;

import java.util.Arrays;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class Leetcode_70 {

    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return process(n, 0, dp);
    }

    private static int process(int n, int index, int[] dp) {
        if (dp[index] != -1) {
            return dp[index];
        }
        if (index > n) {
            dp[index] = 0;
            return dp[index];
        }
        if (n == index) {
            dp[index] = 1;
            return dp[index];
        }
        if (index + 2 <= n) {
            dp[index] = process(n, index + 1, dp) + process(n, index + 2, dp);
            return dp[index];
        }
        dp[index] = process(n, index + 1, dp);
        return dp[index];
    }

    private static int process1(int n, int index, int[] dp) {

        dp[n] = 1;
        int length = dp.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i + 2 <= n) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }

        }
        return dp[0];
    }
}
