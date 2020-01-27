package com._520.leetcode.demo;

/**
 *  字符串匹配
 */
public class Match {

    public static boolean match(char[] str, char[] pattern){
        return matchStr(str, 0, pattern, 0);
    }

    private static boolean matchStr(char[] str, int strIndex, char[] pattern, int patIndex) {
        // 空串或者匹配完成
        if (str.length == strIndex && pattern.length == patIndex) {
            return true;
        }
        // 模式串匹配完，但是字符串还没有完
        if (patIndex == pattern.length){
            return false;
        }
        // 下一个字符是不是 *
        boolean flag = (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*');

        if (flag){      // 下一个匹配字符是 *
            // ad      a*
            // 当前字符匹配
            if (strIndex < str.length && str[strIndex] == pattern[patIndex]){    //
                return matchStr(str, strIndex + 1, pattern, patIndex);
            }else if (pattern[patIndex] == '.'){
                return matchStr(str, strIndex, pattern, patIndex + 2);
            } else {     // 当前字符不匹配
                // 因为后一个是 * 所以直接跳过当前对比
                return matchStr(str, patIndex + 1, pattern, patIndex + 2);
            }
        }else {     // 不是 *
            // 当前字符匹配
            if (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.'){
                return matchStr(str, strIndex + 1, pattern, patIndex + 1);
            }else {     // 当前字符不匹配
                return false;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = {'a', 'a', 'a'};
        char[] pattern = {'a', '.', '*'};
        System.out.println(match(str, pattern));
    }
}
