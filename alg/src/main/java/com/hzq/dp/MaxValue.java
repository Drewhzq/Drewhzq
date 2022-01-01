package com.hzq.dp;

/**
 * 背包问题
 * 给定一组物品，每种物品都有自己的重量和价格，在限定的总重量内，我们如何选择，才能使得物品的总价格最高。
 */
public class MaxValue {

    /**
     * 暴力递归实现
     * @param weight 物品重量
     * @param value 物品的价值
     * @param bag 背包容量
     * @return
     */
    public static int maxValue(int[] weight, int[] value, int bag)
    {
       return process(weight,value,0,bag);
    }

    /**
     *
     * @param weight 不变参数 物品重量
     * @param value 不变参数 物品价值
     * @param index 可变参数，第几个物品
     * @param rest 可变参数  还剩多少容量
     * @return int 返回index之后的物品总价值
     */
    private static int process(int[] weight, int[] value, int index, int rest) {
        //递归终止条件,rest < 0时表示背包已满，该种选择方式被淘汰，返回-1
        if(rest < 0)
        {
            return -1;
        }
        //若背包还有空间，单物品已经选完了,返回0，代表剩余物品的总价值为0
        if(index == weight.length)
        {
            return 0;
        }
        //背包还有空间，物品也没有选完
        //第一种选择，没有选择index位置的物品
        int p1 = process(weight,value ,index+1,rest);
        //第二种选择，选择了index位置的物品
        //首先定义p2=-1
        int p2 = -1;
        int p2Next = process(weight,value,index+1,rest-weight[index]);
        //若p2Next不等于-1，说明该种方式可以拿出来讨论
        if(p2Next != -1)
        {
            p2 = value[index] + p2Next;
        }
        return Math.max(p1,p2);

    }

    public static void main(String[] args) {
        final int i = maxValue(new int[]{3, 2, 4, 7}, new int[]{5, 6, 3, 19}, 11);
        System.out.println(i);;
    }
}
