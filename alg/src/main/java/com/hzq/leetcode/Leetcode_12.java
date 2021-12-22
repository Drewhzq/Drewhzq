package com.hzq.leetcode;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 3999
 */
public class Leetcode_12 {


    public static String intToRoman(int num) {
        String[][] numMap = new String[][]
                {{"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"},
                 {"","X", "XX", "XXX", "XL", "L","LX", "LXX", "LXXX", "XC", "C"},
                 {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM","M"},
                 {"","M","MM","MMM"}
                };

        StringBuilder sb = new StringBuilder();
        sb.append(numMap[3][num / 1000]);
        sb.append(numMap[2][num / 100 % 10]);
        sb.append(numMap[1][num / 10 % 10]);
        sb.append(numMap[0][num % 10]);
        return  sb.toString();
    }
}
