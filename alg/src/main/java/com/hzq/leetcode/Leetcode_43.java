package com.hzq.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Leetcode_43 {

    public static String multiply(String num1, String num2) {

        if(num1 == null || num2 == null)
        {
            throw new RuntimeException("num is null");
        }
        if(num1.equals("0") || num2.equals("0"))
        {
            return "0";
        }
        char[] charNum1 = num1.toCharArray();
        char[] charNum2 = num2.toCharArray();
        int m = charNum1.length;
        int n = charNum2.length;
        int[] res = new int[m+n];

        for(int i = m - 1; i >= 0 ;i--)
        {
            int n1 = charNum1[i] - '0';
            for(int j = n - 1; j >= 0; j--)
            {
                int n2 = charNum2[j] - '0';
                res[i+j+1] = n2 * n1;
            }
        }
        for(int i = m+n-1; i >0; i--)
        {
            res[i-1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        int index = res[0] == 0 ? 1 : 0;

        StringBuilder sb = new StringBuilder();
        while(index < m+n)
        {
            sb.append(res[index]);
            index++;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        multiply("2","3");
    }
}
