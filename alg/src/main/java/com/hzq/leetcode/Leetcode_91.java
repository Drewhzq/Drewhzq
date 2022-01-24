package com.hzq.leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_91 {

    public static int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        //return process(chars,0);
        return process2(chars);

    }

    private static int process(char[] chars, int index) {
        if (index == chars.length) {
            return 1;
        } else if (index > chars.length) {
            return 0;
        }

        if (chars[index] == '0') {
            return 0;
        }
        int res = 0;
        if (chars[index] == '1') {
            //1.单独组成字母
            res += process(chars, index + 1);
            //2.chars[index]char[index+1]组成字母
            return res + process(chars, index + 2);
        }
        if (chars[index] == '2') {
            //1.单独组成字母
            res += process(chars, index + 1);
            //2.chars[index]char[index+1]组成字母
            if (index < chars.length - 1 && chars[index + 1] <= '6') {
                res += process(chars, index + 2);
            }
            return res;
        }
        return process(chars, index + 1);

    }

    private static int process2(char[] chars) {
        int length = chars.length;
        int[] dp = new int[length + 1];

        dp[length] = 1;

        for (int index = dp.length - 2; index >= 0; index--) {
            int res = 0;
            if(chars[index] == '0')
            {
                dp[index] = 0;
            }
            if (chars[index] == '1') {
                //1.单独组成字母
                dp[index] = dp[index + 1];
                //2.chars[index]char[index+1]组成字母
                if(index + 1 <= length)
                {
                    dp[index] += dp[index + 2];
                }

            }
            if (chars[index] == '2') {
                //1.单独组成字母
                res += dp[index + 1];
                //2.chars[index]char[index+1]组成字母
                if (index < length - 1 && chars[index + 1] <= '6') {
                    res += dp[index + 2];
                }
                dp[index] = res;
            } else {
                dp[index] = dp[index+1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        numDecodings("123");
    }

}
