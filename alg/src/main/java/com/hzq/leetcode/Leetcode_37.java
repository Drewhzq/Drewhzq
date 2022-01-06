package com.hzq.leetcode;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_37 {

    public void solveSudoku(char[][] board) {

        int length = board.length;
        boolean[][] row = new boolean[length + 1][length + 1];
        boolean[][] col = new boolean[length + 1][length + 1];
        boolean[][] bul = new boolean[length + 1][length + 1];
        fillBoard(board, row, col, bul);
        process(board, 0, 0, row, col, bul);
    }

    private boolean process(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] bul) {

        if (i == 9) {
            return true;
        }
        int nexti = j == board.length - 1 ? i + 1 : i;
        int nextj = j == board.length - 1 ? 0 : j + 1;
        if (board[i][j] == '.') {
            int tmp = 3 * (i / 3) + j / 3;
            for (int n = 1; n < 10; n++) {
                if (!row[i][n] && !col[j][n] && !bul[tmp][n]) {
                    board[i][j] = (char) (n + '0');
                    row[i][n] = true;
                    col[j][n] = true;
                    bul[tmp][n] = true;
                    if (process(board, nexti, nextj, row, col, bul)) {
                        return true;
                    }
                    row[i][n] = false;
                    col[j][n] = false;
                    bul[tmp][n] = false;
                    board[i][j] = '.';
                }
            }
        } else {
            return process(board, nexti, nextj, row, col, bul);
        }
        return false;
    }

    private void fillBoard(char[][] board, boolean[][] row, boolean[][] col, boolean[][] bul) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int tmp = 3 * (i / 3) + j / 3;
                    int chValue = ch - '0';
                    row[i][chValue] = true;
                    col[j][chValue] = true;
                    bul[tmp][chValue] = true;
                }
            }
        }
    }
}
