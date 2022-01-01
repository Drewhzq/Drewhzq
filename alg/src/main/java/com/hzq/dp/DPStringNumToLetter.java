package com.hzq.dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class DPStringNumToLetter {

    /**
     *动态规划实现
     * @param str
     * @return
     */
    public static int getRes(int num)
    {
        if(num < 0)
        {
            return -1;
        }
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int[] dp = new int[chars.length+1];
        process(chars,0,dp);
        return dp[0];
    }

    private static void process(char[] chars, int index, int[] dp) {

        int length = chars.length;

        dp[length] = 1;

        for(int i = length - 1; i>=0 ;i--)
        {
            if(chars[index] == '1')
            {
                int res = 0;
                //第一种可能，char[index]自己单独变成a
                dp[i] = dp[i+1];
                //第二种可能，char[index]char[index+1]组成一个字母
                if(index+1 < length)
                {
                    dp[i]+=dp[i+2];
                }
            }

            else if(chars[index] == '2')
            {
                int res = 0;
                //第一种可能，char[index]自己单独变成字母
                dp[i] = dp[i+1];
                //第二种可能，char[index]char[index+1]组成一个字母
                if(index+1 < length && chars[index+1] <'6' )
                {
                    dp[i]+=dp[i+2];
                }
            }
            //数字在3-9之间
            else {

                dp[i] = dp[i+1];
            }
        }

    }
}
