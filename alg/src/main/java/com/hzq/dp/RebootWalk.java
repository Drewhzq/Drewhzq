package com.hzq.dp;

/**
 * 假设有排成一行的N个位置，记为：1~N，N一定大于或等于2
 * 开始时机器人在其中的M位置上(M一定是1~N中的一个)
 * 如果机器人来到1的位置，那么下一步只能往右来到2的位置
 * 如果机器人来到N的位置，那么下一步只能往左来到N-1的位置
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走
 * 规定机器人开始在M位置，必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P,返回方法数。
 * ————————————————
 * 版权声明：本文为CSDN博主「方舟笔记」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/dawnto/article/details/121137598
 */
public class RebootWalk {
    /**
     * 暴力递归
     * @param N N个位置
     * @param M 起始位置
     * @param K 行走K步
     * @param P 终止位置
     * @return
     */
    public static int walkNums(int N, int M, int K, int P)
    {
        if(N < 2 || M < 1 || K < 1 || P < 1)
        {
            return -1;
        }
       return process(N, M, K, P);
    }

    /**
     *
     * @param n
     * @param index
     * @param k
     * @param end
     */
    private static int process(int n, int index, int k, int end) {

        if(k == 0)
        {
            return index == end ? 1 : 0;
        }

        if(index == 1)
        {
            return process(n, 2,k-1,end);
        }
        if(index == n )
        {
            return process(n, index - 1,k-1,end);
        }

        return process(n,index+1,k-1,end) + process(n, index-1,k-1,end);
    }
}
