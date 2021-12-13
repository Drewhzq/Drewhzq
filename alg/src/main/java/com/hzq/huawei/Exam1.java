package com.hzq.huawei;

import java.util.*;

/**
 * 字符出现次数及重排序
 */
public class Exam1 {

    public static Map<Character, Integer> getRes(String word) {
        Map<Character, Integer> res = new HashMap<>();

        if (word == null || word.length() == 0 || !word.matches("[a-zA-Z]+")) {
            return res;
        }

        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (res.get(chars[i]) == null) {
                res.put(chars[i], 1);
            } else {
                res.put(chars[i], res.get(chars[i]) + 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Map<Character, Integer> res = getRes(line);
            Set<Map.Entry<Character, Integer>> entrySet = res.entrySet();
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            list.addAll(entrySet);
            Collections.sort(list, (a, b) ->
            {
                if (b.getValue() - a.getValue() > 0) {
                    return 1;
                } else if (b.getValue() == a.getValue()) {
                    if (a.getKey() >= 'a' && b.getKey() >= 'a') {
                        return a.getKey() - b.getKey();
                    } else if (a.getKey() >= 'A' && a.getKey() < 'a' && b.getKey() >= 'A' && a.getKey() <'a') {
                        return a.getKey() - a.getKey();
                    } else {
                        return b.getKey() - a.getKey();
                    }
                }
                return -1;
            });
            for (Map.Entry<Character, Integer> entry : list) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + ";");

            }
        }
    }
}
