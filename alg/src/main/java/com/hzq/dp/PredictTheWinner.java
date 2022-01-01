package com.hzq.dp;

/**
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 *
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），
 * 取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 *
 * 返回胜利方的分值
 */
public class PredictTheWinner {

    public static int winnerScores(int[] nums)
    {
        if(nums == null ||nums.length < 1)
        {
            return 0;
        }

        return Math.max(f(nums, 0,nums.length-1),s(nums, 0, nums.length-1));
    }

    /**
     * 后手选择
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int s(int[] nums, int left, int right) {
        if(left == right)
        {
            return 0;
        }
        return Math.min(f(nums,left+1,right),f(nums,left,right-1));
    }

    /**
     * 先手选择
     */
    private static int f(int[] nums, int left, int right) {
        if(left == right)
        {
            return nums[left];
        }

        return Math.max(nums[left] + s(nums,left+1,right),nums[right]+s(nums,left,right-1));
    }
}
