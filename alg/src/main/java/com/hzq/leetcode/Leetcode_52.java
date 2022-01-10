package com.hzq.leetcode;

import java.util.Arrays;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_52 {

    public static int totalNQueens(int n) {

        if (n <= 0) {
            return 0;
        }
        int[] record = new int[n << 1];
        int res = 0;

        return process(0, record, n);
    }

    private static int process(int index, int[] record, int n) {

        if (index == n) {
            return 1;
        }

        //尝试所有列
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isVaild(record, index, j)) {
                record[index] = j;
                res += process(index + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isVaild(int[] record, int index, int j) {

        for (int i = 0; i < index; i++) {
            if (j == record[i] || Math.abs(record[i] - j) == Math.abs(index - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        totalNQueens(4);
    }
}
