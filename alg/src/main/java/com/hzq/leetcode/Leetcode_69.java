package com.hzq.leetcode;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_69 {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 3) {
            return 1;
        }

        long res = 1;
        long left = 1;
        long right = x;
        long mid = 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (mid * mid <= x) {
                res = mid * mid;
                left = mid + 1;
            } else {
                 right = mid - 1;
            }
        }
        return (int)res;

    }
}
