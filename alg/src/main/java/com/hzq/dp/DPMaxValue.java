package com.hzq.dp;

/**
 * 背包问题
 * 给定一组物品，每种物品都有自己的重量和价格，在限定的总重量内，我们如何选择，才能使得物品的总价格最高。
 */
public class DPMaxValue {
    /**
     * 动态规划实现
     * @param weight 物品重量
     * @param value 物品的价值
     * @param bag 背包容量
     * @return
     */
    public static int maxValue(int[] weight, int[] value, int bag)
    {
        return process(weight,value,bag);
    }

    /**
     *
     * @param weight 不可变参数 物品重量
     * @param value 不可变参数 物品价值
     * @param rest
     * @return 返回index后的物品总价值
     */
    private static int process(int[] weight, int[] value, int rest) {

        final int length = weight.length;
        int[][] dp = new int[length+1][rest+1];


        for(int i = length -1; i>=0; i--)
        {
            for(int j = 0; j<=rest;j++)
            {
                int p1 = dp[i+1][j];
                int p2 = -1;
                if(j - weight[i] >= 0)
                {
                    int p2Next = dp[i+1][j-weight[i]];
                    p2 = p2Next + value[i];
                }
                dp[i][j] = Math.max(p1,p2);

            }
        }
        return dp[0][rest];
    }

    public static void main(String[] args) {
        final int i = maxValue(new int[]{3, 2, 4, 7}, new int[]{5, 6, 3, 19}, 11);
        System.out.println(i);
    }
}
