package com.hzq.leetcode;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class Leetcode_73 {

    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        {
            return;
        }

        boolean colIsZero = false;
        boolean rowIsZero = false;
        for(int i = 0; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0)
            {
                colIsZero = true;
                break;
            }
        }

        for(int i = 0; i < matrix.length;i++)
        {
            if(matrix[i][0] == 0)
            {
                rowIsZero = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length;i++)
        {
            for(int j = 1; j < matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length;j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }

        }

        if(colIsZero)
        {
            for(int i = 0 ; i < matrix[0].length;i++)
            {
                matrix[0][i] = 0;
            }
        }

        if(rowIsZero)
        {
            for(int i = 0; i<matrix.length;i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
