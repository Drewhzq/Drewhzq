package com.hzq.leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_7 {

    public static int reverse(int x) {

        //判断x是不是正数
        boolean isPos = ((x >>> 31) & 1) == 0;

        int m = Integer.MIN_VALUE / 10;
        int n = Integer.MIN_VALUE % 10;
        int res = 0;
        if(isPos)
        {
            x = -x;
        }
        while(x != 0)
        {
            if(res < m || (res == m && x % 10 < n))
            {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;

        }
        return isPos ? Math.abs(res) : res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
