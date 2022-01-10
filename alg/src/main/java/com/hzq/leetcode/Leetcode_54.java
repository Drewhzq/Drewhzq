package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length < 1)
        {
            return res;
        }
        int tr = 0;
        int tc = 0;
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;

        while(tr < dr && tc < dc)
        {
            addElement(matrix,res,tr++,tc++,dr--,dc--);
        }
        return res;
    }

    private static void addElement(int[][] matrix, List<Integer> res, int tr, int tc, int dr, int dc) {

        if(tr == dr)
        {
            for(int i = tc; i <= dc;i++)
            {
                res.add(matrix[tr][i]);
            }
            return;
        }

        if(tc == dc)
        {
            for(int i = tr; i<=dr;i++)
            {
                res.add(matrix[i][tc]);
            }
            return;
        }
        int i = tc;
        while(i < dc)
        {
            res.add(matrix[tr][i]);
            i++;
        }

        i = tr;
        while(i < dr)
        {
            res.add(matrix[i][dc]);
            i++;
        }
        i = dc;
        while(i > tc)
        {
            res.add(matrix[dr][i]);
            i--;
        }
        i = dr;
        while(i > tr)
        {
            res.add(matrix[i][tc]);
            i--;
        }

    }

    public static void main(String[] args) {
        //spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        spiralOrder(new int[][]{{1,2,3,4,5,6,7,8,9,10}});
    }

}
