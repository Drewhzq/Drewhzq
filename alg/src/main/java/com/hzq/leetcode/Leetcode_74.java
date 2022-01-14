package com.hzq.leetcode;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_74 {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rowLength - 1][colLength - 1]) {
            return false;
        }
        int targetRow = 0;
        int smallFirst = 0;
        int largeFirst = rowLength - 1;

        while (smallFirst <= largeFirst) {
            int mid = (largeFirst + smallFirst) / 2;
            if (matrix[mid][0] < target) {
                targetRow = mid;
                smallFirst = mid + 1;

            } else if (matrix[mid][0] > target) {
                largeFirst = mid -1;
            } else {
                return true;
            }
        }

        int left = 0;
        int right = colLength - 1;
        while (left <= right) {
            int mid = (right + left) / 2;

            if (matrix[targetRow][mid] == target) {
                return true;
            }
            if (matrix[targetRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        searchMatrix(new int[][]{{1},{3}},3);
    }
}
