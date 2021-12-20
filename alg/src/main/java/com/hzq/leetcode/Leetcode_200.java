package com.hzq.leetcode;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 */
public class Leetcode_200 {

    public static int numIslands(char[][] grid) {
        if(grid == null)
        {
            return 0;
        }
        int res = 0;
        int M = grid.length;
        int N= grid[0].length;
        for(int i = 0 ; i < M; i++)
        {
            for(int j = 0; j<N; j++)
            {
                if(grid[i][j] == 1)
                {
                    res++;
                    infectNums(grid,i,j,M,N);
                }
            }
        }
        return res;
    }

    private static void infectNums(char[][] grid, int i, int j, int m, int n)
    {
        if(i < 0 || i>=m || j<0 ||j>=n || grid[i][j]!=1)
        {
            return;
        }
        grid[i][j] = 2;
        infectNums(grid,i+1,j,m,n);
        infectNums(grid,i-1,j,m,n);
        infectNums(grid,i,j-1,m,n);
        infectNums(grid,i,j+1,m,n);
    }
}
