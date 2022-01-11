package com.hzq.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class Leetcode_64 {
    public static int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        return process(0, 0, grid, sum, min);

    }

    private static int process(int row, int col, int[][] grid, int sum, int min) {

        int rowLength = grid.length;
        int colLength = grid[0].length;
        if (row == rowLength - 1 && colLength == colLength - 1) {
            min = Math.min(min, sum);
            return min;
        }

        if (row == rowLength - 1) {
            for (int i = col; i < colLength; i++) {
                sum += grid[row][i];

            }
            return sum;
        }

        if (col == colLength - 1) {
            for (int i = row; i < rowLength; i++) {
                sum += grid[i][col];
            }
            return sum;
        }

        if (col + 1 < colLength && row + 1 < rowLength) {
            sum += grid[row][col];
            return Math.min(process(row, col + 1, grid, sum, min), process(row + 1, col, grid, sum, min));
        }
        return 0;
    }


    public static int minPathSum1(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        return process1(grid);
    }

    private static int process1(int[][] grid) {


        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < colLength; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < rowLength; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for(int rowIndex = 1 ;rowIndex < rowLength;rowIndex++)
        {
            for(int colIndex = 1;colIndex < colLength;colIndex++)
            {
                dp[rowIndex][colIndex] = grid[rowIndex][colIndex] + Math.min(dp[rowIndex-1][colIndex],dp[rowIndex][colIndex-1]);
            }
        }

        return dp[rowLength-1][colLength-1];
    }

}
