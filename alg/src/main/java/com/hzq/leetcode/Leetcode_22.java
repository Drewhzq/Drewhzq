package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Leetcode_22 {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
            
        char[] strs = new char[n<<1];
        
        process(strs,0,0,n,res);
        return res;

    }

    /**
     *
     * @param strs
     * @param index
     * @param leftMinuRight 左边“（” 减去 右边 “）”还能有几个 “（ ”
     * @param leftRest
     * @param res
     */
    private static void process(char[] strs,int index, int leftMinuRight, int leftRest, List<String> res) {

        if(index == strs.length)
        {
            res.add(new String(strs));
            return;
        }
        if(leftRest > 0)
        {
            strs[index] = '(';
            process(strs,index+1, leftMinuRight+1,leftRest-1,res);
        }
        if(leftMinuRight > 0)
        {
            strs[index] = ')';
            process(strs,index+1, leftMinuRight-1, leftRest,res);
        }
    }
}
