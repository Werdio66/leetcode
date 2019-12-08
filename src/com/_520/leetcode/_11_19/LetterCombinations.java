package com._520.leetcode._11_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *      给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *      给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {



    public List<String> letterCombinations(String digits) {
        List<String> strings = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        List<String> combination = new ArrayList<>();
        if (digits.length() == 0){
            return combination;
        }
        combination.add("");

        for (int i = 0; i < digits.length(); i++) {
            // "123" 计算
            int index = digits.charAt(i) - '0';
            // 取出符合第一个数字的字符串
            String string = strings.get(index);
            // 为集合中每个字符串增加元素
            int size = combination.size();
            for (int k = 0; k < size; k++) {

                // 每次取出第一个字符串
                String temp = combination.remove(0);

                for (int j = 0; j < string.length(); j++) {
                    // 如果有后续的元素，加在第一个字符串后面
                    combination.add(temp + string.charAt(j));
                }
            }
        }


        return combination;
    }

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        String digits = new String("");
        System.out.println(l.letterCombinations(digits));
    }
}
