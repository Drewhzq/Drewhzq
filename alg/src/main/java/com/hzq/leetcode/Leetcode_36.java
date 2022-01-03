package com.hzq.leetcode;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_36 {

    public static boolean isValidSudoku(char[][] board) {

        int length = board.length;
        boolean[][] row = new boolean[length+1][length+1];
        boolean[][] col = new boolean[length+1][length+1];
        boolean[][] bul = new boolean[length+1][length+1];

        for(int i = 0; i < length;i++)
        {
            for(int j = 0;j < length;j++)
            {
                if(board[i][j] != '.')
                {
                    int tmp = 3*(i / 3) + j / 3;
                    int value = board[i][j] - '0';
                    if(row[i][value] || col[j][value] || bul[tmp][value])
                    {
                        return false;
                    }
                    row[i][value] = true;
                    col[j][value] = true;
                    bul[tmp][value] = true;
                }
            }
        }
        return true;

    }
}
