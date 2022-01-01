package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_51 {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>>  res = new ArrayList<>();
        if(n <= 0)
        {
            return res;
        }

        char[][] context = new char[n][n];
        for(int i = 0; i<n;i++)
        {
            Arrays.fill(context[i],'.');

        }
        //i行的皇后，放到了record[i]列
        int[] record = new int[n<<1];
        process(0,record,n,context,res);
        return res;
    }

    /**
     *  @param i
     * @param record
     * @param n
     * @param context
     * @param res
     */
    private static void process(int i, int[] record, int n, char[][] context, List<List<String>> res)
    {

        //终止行
        if(i == n)
        {
            List<String> list = new ArrayList<>();
            for(int c = 0 ; c < n; c++)
            {
                list.add(new String(context[c]));
            }
            res.add(list);
            return;
        }
        //尝试所有列
        for(int j = 0; j < n ; j++)
        {
            if(isVaild(record,i,j))
            {
                record[i] = j;
                context[i][j] = 'Q';
                process(i+1,record,n,context, res);
                //记得还原
                context[i][j] = '.';
            }
        }

    }

    /**
     * 判断皇后放i行j列是否合法
     * @param record
     * @param i
     * @param j
     * @return
     */
    private static boolean isVaild(int[] record, int i, int j) {

        for(int k = 0; k < i; k++)
        {
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(k-i))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
