package com.hzq.leetcode;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        return process(0, 0, obstacleGrid);

    }

    private static int process(int row, int col, int[][] obstacleGrid) {

        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            if (obstacleGrid[row][col] == 1) {
                return 0;
            }
            return 1;
        }

        if (row == obstacleGrid.length - 1) {
            int i = col;
            while (i != obstacleGrid[0].length) {
                if (obstacleGrid[row][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if (col == obstacleGrid[0].length - 1) {
            int i = row;
            while (i != obstacleGrid.length) {
                if (obstacleGrid[i][col] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        int res = 0;
        if (obstacleGrid[row][col + 1] != 1) {
            res += process(row, col + 1, obstacleGrid);

        }
        if (obstacleGrid[row + 1][col] != 1) {
            res += process(row + 1, col, obstacleGrid);
        }
        return res;
    }


    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return process1(dp, obstacleGrid);

    }

    private static int process1(int[][] dp, int[][] obstacleGrid) {

        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;

        if (obstacleGrid[rowLength - 1][colLength - 1] == 1) {
            return 0;
        } else if (obstacleGrid[rowLength - 1][colLength - 1] == 0) {
            dp[rowLength - 1][colLength - 1] = 1;
        }
        for(int i = rowLength - 2; i >= 0 && obstacleGrid[i][colLength - 1] == 0;i--)
        {
            dp[i][colLength - 1] = dp[i+1][colLength - 1];
        }

        for(int i = colLength - 2; i >= 0 && obstacleGrid[rowLength - 1][i] == 0;i--)
        {
            dp[rowLength - 1][i] = dp[rowLength - 1][i+1] ;
        }

        for(int row = rowLength - 2;row >= 0;row--)
        {

            for(int col = colLength - 2; col >= 0; col--)
            {
                if (obstacleGrid[row][col] != 1) {
                    dp[row][col]= dp[row][col+1] + dp[row+1][col];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] tmp = new int[][]{{0, 0,0}, {0,1, 0}, {0, 0,0}};
        uniquePathsWithObstacles1(tmp);
    }
}
