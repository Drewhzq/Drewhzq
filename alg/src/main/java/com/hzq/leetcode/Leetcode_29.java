package com.hzq.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_29 {

    /**
     * 加法
     * @param num1
     * @param num2
     * @return
     */
    public static int add(int num1, int num2) {

        int sum = num1;
        while(num2 != 0)
        {
            //无进位相加
            sum = num1 ^ num2;
            //相加进位信息
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return sum;
    }

    /**
     * 减法
     * @param num1
     * @param num2
     * @return
     */
    public static int minus(int num1, int num2) {

        //取num2的相反数
        int negNum = getNeg(num2);
        return add(num1,negNum);
    }

    /**
     * 取反
     * @param num2
     * @return
     */
    private static int getNeg(int num2) {
        //取反再加一
        return add(~num2,1);
    }

    /**
     * 乘法
     * @param num1
     * @param num2
     * @return
     */
    public static int multi(int num1, int num2) {

        int count = 0;
        while(num2 != 0)
        {
            if((num2 & 1) != 0)
            {
                count = add(count, num1);
            }
            num1 <<= 1;
            num2 >>>= 1;
        }
        return count;

    }

    /**
     * 除法
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {

        if(divisor == Integer.MIN_VALUE)
        {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        //除数不是系统最小

        if(dividend == Integer.MIN_VALUE)
        {
            if(divisor == getNeg(1))
            {
                return Integer.MAX_VALUE;
            }
            int res = div(add(dividend,1),divisor);
            return add(res, div(minus(dividend,multi(res, divisor)), divisor));
        }
        //都不是系统最小

        return div(dividend, divisor);

    }

    /**
     * 除法
     * @param num1
     * @param num2
     * @return
     */
    private static int div(int num1, int num2) {

        int x = isNeg(num1) ? getNeg(num1) : num1;
        int y = isNeg(num2) ? getNeg(num2) : num2;
        int res = 0;
        for(int i = 31; i >=0 ; i = minus(i,1))
        {
            if((x >> i) >= y )
            {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(num1) ^ isNeg(num2) ? getNeg(res) : res;

    }

    /**
     * 判断是否为负数
     * @param num1
     * @return
     */
    private static boolean isNeg(int num1) {
        return ((num1 >>>31) & 1) == 1;
    }

    public static void main(String[] args) {
        System.out.println(add(1,3));
        System.out.println(minus(5,3));
        System.out.println(multi(3,6));
        System.out.println(div(5,2));
    }


}
