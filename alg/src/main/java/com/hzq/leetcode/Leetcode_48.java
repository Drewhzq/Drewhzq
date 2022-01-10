package com.hzq.leetcode;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_48 {

    public static void rotate(int[][] matrix) {

        int dc = matrix.length - 1;

        int tc = 0;

        while(tc < dc)
        {
            goutpRotate(matrix,tc++,dc--);
        }
    }

    private static void goutpRotate(int[][] matrix, int tc, int dc) {

        int tr = tc;
        int dr = dc;
        for(int i = 0; i < dc - tc; i++)
        {
            int tmp = matrix[tr][tc+i];
            matrix[tr][tc+i] = matrix[dr-i][tc];
            matrix[dr-i][tc] = matrix[dr][dc-i];
            matrix[dr][dc-i] = matrix[tr+i][dc];
            matrix[tr+i][dc] = tmp;
        }
    }
}
