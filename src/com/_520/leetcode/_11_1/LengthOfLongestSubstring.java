package com._520.leetcode._11_1;

import java.util.HashMap;
import java.util.Map;

/**
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LengthOfLongestSubstring {

    private static int lengthOfLongestSubstring(String s) {
        // 判断是否为空
        if (s.equals(""))
            return 0;
        // 判断是否有空格
        if (s.trim().equals(""))
            return 1;
//        System.out.println(s);
        int Maxlength = 0;     // 记录最长字串
        Map<Character,Integer> map = new HashMap<>();       // key存放字符，value存放下标
        for (int begin = 0, end = 0; end < s.length(); end++) {

            // 判断在map中是否存在当前字符
            if (map.containsKey(s.charAt(end))){
                // 把较大的下标赋值给begin，避免有多个相同字符串时从最小的下标开始
                begin = begin > map.get(s.charAt(end)) ? begin : map.get(s.charAt(end));
            }

            // 最长的字串
            Maxlength = Maxlength > (end - begin + 1) ? Maxlength : (end - begin + 1);

            // 把当前字符串和下标存入map
            map.put(s.charAt(end),end + 1);
//            System.out.println(" begin = " + begin + " end = " + end);
//            System.out.println(map);
//            System.out.println(Maxlength);
        }

        return Maxlength;
    }

    public static void main(String[] args) {
        String str = "";
        int length = lengthOfLongestSubstring(str);
        System.out.println(length);
    }
}
