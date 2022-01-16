package com.hzq.leetcode;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_79 {

    public static boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                if(process(board, i, j, chars, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean process(char[][] board, int i, int j, char[] chars, int index) {

        if (index == chars.length) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != chars[index]) {
            return false;
        }
        boolean res = false;
        char tmp = board[i][j];
        board[i][j] = '0';
        res = process(board, i + 1, j, chars, index + 1)
                || process(board, i, j + 1, chars, index + 1)
                || process(board, i - 1, j, chars, index + 1)
                || process(board, i, j - 1, chars, index + 1);
        board[i][j] = tmp;
        return res;
    }
}
