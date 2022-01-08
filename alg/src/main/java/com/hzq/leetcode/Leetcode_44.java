package com.hzq.leetcode;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_44 {

    public static boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();

        return process1(charS, charP, 0, 0);

    }

    /**
     * 暴力递归
     *
     * @param charS
     * @param charP
     * @param s
     * @param p
     * @return
     */
    private static boolean process1(char[] charS, char[] charP, int s, int p) {
        //终止条件
        if (s == charS.length) {
            if (p == charP.length) {
                return true;
            } else {
                return charP[p] == '*' && process1(charS, charP, s, p + 1);
            }
        }

        if (p == charP.length) {
            return false;
        }

        if (charP[p] == '?') {
            return process1(charS, charP, s + 1, p + 1);
        }

        if (charP[p] == '*') {
            for (int index = 0; index <= charS.length - s; index++) {
                if (process1(charS, charP, s + index, p + 1)) {
                    return true;
                }
            }
        }
        if (charP[p] != '?' && charP[p] != '*') {
            return charP[p] == charS[s] && process1(charS, charP, s + 1, p + 1);
        }
        return false;
    }

    /**
     * 动态规划
     * 未优化版本
     * @param charS
     * @param charP
     * @param s
     * @param p
     * @return
     */
    private static boolean process2(char[] charS, char[] charP, int s, int p) {
        int sLength = charS.length;
        int pLength = charP.length;
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[sLength][pLength] = true;

        for (int i = pLength - 1; i >= 0; i--) {
            dp[sLength][i] = charP[i] == '*' && dp[sLength][i + 1] ;
        }

        for (int i = sLength - 1; i >= 0; i--) {
            for (int j = pLength - 1; j >= 0; j--) {

                if (charP[j] == '?') {
                   dp[i][j] = dp[i + 1][j + 1];
                   continue;
                }

                if (charP[j] == '*') {
                    for (int index = 0; index <= charS.length - i; index++) {
                        if (dp[i + index][j + 1]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
                if (charP[j] != '?' && charP[j] != '*') {
                    dp[i][j] =  charP[j] == charS[i] && dp[i + 1][j + 1];
                    continue;
                }

            }
        }
        return dp[0][0];
    }
    /**
     * 动态规划
     * 斜率优化
     * @param charS
     * @param charP
     * @param s
     * @param p
     * @return
     */
    private static boolean process3(char[] charS, char[] charP, int s, int p) {
        int sLength = charS.length;
        int pLength = charP.length;
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[sLength][pLength] = true;

        for (int i = pLength - 1; i >= 0; i--) {
            dp[sLength][i] = charP[i] == '*' && dp[sLength][i + 1] ;
        }

        for (int i = sLength - 1; i >= 0; i--) {
            for (int j = pLength - 1; j >= 0; j--) {

                if (charP[j] == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                    continue;
                }

                if (charP[j] == '*') {

                    dp[i][j] = dp[i][j+1] || dp[i+1][j];
                }
                if (charP[j] != '?' && charP[j] != '*') {
                    dp[i][j] =  charP[j] == charS[i] && dp[i + 1][j + 1];
                    continue;
                }

            }
        }
        return dp[0][0];
    }

}
