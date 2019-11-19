package com._520.leetcode._11_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *      给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *      给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> strings = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        List<String> zuhe = new ArrayList<>();
        int len = digits.length();

        String[] str = new String[len];
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0';
            str[i] = strings.get(index);
            if (len == 1){
                for (int j = 0; j < str[i].length(); j++) {
                    zuhe.add(str[i].charAt(j) + "");
                }
                return zuhe;

            }
        }
        for (int k = 0; k < str.length; k++) {
            for (int i = 0; i < str[k].length(); i++) {
                if (k + 1 >= str.length)
                    break;
                for (int j = 0; j < str[k + 1].length(); j++) {

//                    System.out.println(str[k].charAt(i) + "    " +str[k + 1].charAt(j));
                    zuhe.add(str[k].charAt(i) + "" +str[k + 1].charAt(j));
                }
            }
        }


        return zuhe;
    }

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        String digits = new String("234");
        System.out.println(l.letterCombinations(digits));
    }
}
