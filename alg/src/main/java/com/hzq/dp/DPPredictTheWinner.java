package com.hzq.dp;

public class DPPredictTheWinner {

    /**
     * 动态规划实现
     *
     * @param nums
     * @return
     */
    public static int winnerScores(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        //return Math.max(f(nums, 0,nums.length-1),s(nums, 0, nums.length-1));
        return process(nums);
    }

    private static int process(int[] nums) {
        final int length = nums.length;
        //先手dp
        int[][] left = new int[length + 1][length + 1];

        //后手dp 后手dp中 L==R 值为0
        int[][] right = new int[length + 1][length + 1];
        //对于先手dp, 当L == R时值为L
        for (int i = 0; i < left.length; i++) {
            left[i][i] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            int row = 0;
            int col = i;
            while(row < length && col < length)
            {
                left[row][col] = Math.max(nums[row]+right[row+1][col],nums[col]+right[row][col-1]);
                right[row][col] = Math.min(left[row+1][col],left[row][col-1]);
                row++;
                col++;
            }

        }
        return Math.max(left[0][length-1],right[0][length-1]);
    }
}
