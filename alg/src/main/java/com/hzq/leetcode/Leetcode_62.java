package com.hzq.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_62 {

    public static int uniquePaths(int m, int n) {

        int allSteps = m + n - 2;
        int part = m - 1;
        long o1 = 1;
        long o2 = 1;
        for(int i = allSteps - part + 1, j = 1; i <= allSteps || j <= part; i++,j++)
        {
            o1 *= i;
            o2 *= j;
            long gcd = getGcd(o1,o2);
            o1 /= gcd;
            o2 /= gcd;
        }
        return (int)o1;
    }

    //求i j的最大公约数
    private static long getGcd(long i, long j) {
        return j == 0 ? i : getGcd(j, i % j);
    }

    public static void main(String[] args) {
        uniquePaths(5,3);
    }
}
