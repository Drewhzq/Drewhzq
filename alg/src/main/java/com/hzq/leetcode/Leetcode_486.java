package com.hzq.leetcode;

/**
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 *
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 *
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_486 {

    public static boolean PredictTheWinner(int[] nums) {
        if((nums.length & 1) ==0)
        {
            return true;
        }
        return f(nums, 0,nums.length-1) >= s(nums, 0, nums.length-1);
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
