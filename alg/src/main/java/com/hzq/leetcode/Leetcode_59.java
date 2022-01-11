package com.hzq.leetcode;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *  
 *
 * 示例 1：

 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_59 {

    public int[][] generateMatrix(int n) {
        if(n < 1)
        {
            return null;
        }
        if(n == 1)
        {
            return new int[][]{{1}};
        }
        int tr = 0;
        int tc = 0;

        int dr = n - 1;
        int dc = n - 1;

        int[][] res = new int[n][n];
        int start = 1;
        while(tr <= dr)
        {
            start = generateNums(res,tr++,tc++, dr--,dc--,start);
            if(tr == dr && tc == dc)
            {
                res[tr][tc] = n*n;
                break;
            }
        }
        return res;

    }

    private static int generateNums(int[][] res, int tr,int tc, int dr,int dc, int start) {


        for(int i = tc ,j = tr; i < dc; i++)
        {
            res[j][i] = start++;
        }

        for(int i = tr,j = dc; i < dr;i++)
        {
            res[i][j] = start++;
        }

        for(int i = dc,j = dr; i > tc; i--)
        {
            res[j][i] = start++;
        }

        for(int i = dr ,j = tc; i > tr; i-- )
        {
            res[i][j] = start++;
        }
        return start;

    }
}
