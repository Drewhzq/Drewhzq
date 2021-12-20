package com.hzq.leetcode;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Leetcode_5 {

    /**
     * manacher算法
     *
     * @param str
     * @return
     */
    public static String longestPalindrome(String str) {

        if (str == null) {
            return "";
        }

        char[] newString = generateManacherString(str);

        int center = -1;
        int pRight = -1;
        int[] pArry = new int[newString.length];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < newString.length; i++) {
            pArry[i] = pRight > i ? Math.min(pArry[center * 2 - i], pRight - i) : 1;

            while (i + pArry[i] < newString.length && i - pArry[i] >= 0) {
                if (newString[i + pArry[i]] == newString[i - pArry[i]]) {
                    pArry[i]++;
                } else {
                    break;
                }
            }

            if (i + pArry[i] > pRight) {
                center = i;
                pRight = i + pArry[i];
            }

            maxIndex = max > pArry[i] ? maxIndex : i;
            max = Math.max(max, pArry[i]);
        }
        String resStr = new String(newString);
        return recoverString(resStr.substring(maxIndex - max + 1, maxIndex + max));
    }

    private static String recoverString(String substring) {
        char[] chars = substring.toCharArray();
        char[] res = new char[chars.length / 2];
        if ((chars.length & 1) == 1) {
            for (int i = 0; i < res.length; i++) {
                res[i] = chars[2*i + 1];
            }
        } else {
            for(int i = 0; i < res.length;i++)
            {
                res[i] = chars[2*i];
            }
        }
        return new String(res);
    }

    private static char[] generateManacherString(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[2 * str.length() + 1];

        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chars[i / 2];
        }
        return res;
    }

    public static void main(String[] args) {
        final char[] chars = generateManacherString("babad");

        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
