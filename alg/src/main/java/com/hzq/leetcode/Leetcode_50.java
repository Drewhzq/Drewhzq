package com.hzq.leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_50 {
    public static double myPow(double x, int n) {

        if(n == 0)
        {
            return 1d;
        }
        if( n == Integer.MIN_VALUE)
        {
            return x == 1d || x == -1d ? 1d : 0;
        }
        int absN = Math.abs(n);

        double pow = 1d;
        double tmp = x;
        while(absN != 0)
        {
            //判断n的二进制位上是否是1
            if((absN & 1) == 1)
            {
                pow *=tmp;
            }
            absN = absN >> 1;
            tmp = tmp * tmp;
        }
     return n < 0 ? 1d / pow : pow;
    }

    public static void main(String[] args) {
        final double myPow = myPow(2, 10);
        System.out.println(myPow);
    }

}
