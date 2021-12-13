package com.hzq.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * 字符串消消乐
 */
public class Exam {

    public static int getRes(String word) {

        if (word == null || word.length() == 0) {
            return 0;
        }

        char[] chars = word.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            //push时遇到相同的即消除
            if (!stack.isEmpty() && stack.peek() == chars[i]) {
                stack.pop();
                continue;
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            int res = getRes(line);
            System.out.println(res);
        }
    }



}
