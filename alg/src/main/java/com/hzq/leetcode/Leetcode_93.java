package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_93 {
    public static List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return res;
        }
        List<String> list = new ArrayList<>();
        process(s, 0, list, res);
        return res;

    }

    private static void process(String s, int index, List<String> list, List<String> res) {

        int length = s.length();
        if (index == length && list.size() == 4) {
            //收集结果
            res.add(generateRes(list));
            return ;

        } else if (index > length || (index < length && list.size() == 4)) {
            return ;
        }

        if (index < s.length() && s.charAt(index) == '0') {
            list.add("0");
            process(s, index + 1, list, res);
            list.remove(list.size() - 1);
        } else {

            if(index+1 <= s.length())
            {
                list.add(s.substring(index, index + 1));
                process(s, index + 1, list, res);

                list.remove(list.size() - 1);

            }


            if(index+2 <= s.length())
            {
                list.add(s.substring(index, index + 2));
                process(s, index + 2, list, res);

                list.remove(list.size() - 1);

            }


            if(index + 3 <= s.length())
            {
                if (s.substring(index, index + 3).compareTo("255") <= 0) {
                    list.add(s.substring(index, index + 3));
                    process(s, index + 3, list, res);

                    list.remove(list.size() - 1);

                }
            }
        }
    }

    private static String generateRes(List<String> list) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(list.get(i) + ".");
        }
        sb.append(list.get(3));
        return sb.toString();
    }

    public static void main(String[] args) {
        restoreIpAddresses("010010");
        //System.out.println("1234567".substring(6,7));
    }
}
