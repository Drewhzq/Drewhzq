package com.hzq.leetcode;

import java.util.Arrays;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_6 {

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        String[] strs = new String[numRows];
        Arrays.fill(strs,"");
        final char[] chars = s.toCharArray();

        int period = 2 * numRows - 2;
        for (int i = 0; i < chars.length; i++) {
            int mod = i % period;
            if (mod < numRows) {
                strs[mod] += chars[i];
            } else {
                strs[period-mod] += chars[i];
            }
        }

        final StringBuilder builder = new StringBuilder();
        for(String str : strs)
        {
            builder.append(str);
        }
        return builder.toString();
    }
}
