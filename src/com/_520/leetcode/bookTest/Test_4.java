package com._520.leetcode.bookTest;

import java.util.Arrays;

public class Test_4 {

    /**
     *  替换字符串中的空格
     * @param str           原字符串
     * @param replace       替换空格的字符串
     * @return              替换后的字符串
     */
    private static String replaceAll(String str, String replace){
        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)){
                spaceCount++;
            }
        }
        Character[] characters = new Character[str.length() + spaceCount * (replace.length() - 1)];
        int begin = str.length() - 1;
        int end = characters.length - 1;

        while (begin < end){

            while (begin < end && ' ' != str.charAt(begin)){
                characters[end] = str.charAt(begin);
                end--;
                begin--;
            }

            if (' ' == str.charAt(begin)) {
                for (int i = replace.length() - 1; i >= 0; i--){
                    characters[end] = replace.charAt(i);
                    end--;
                }
                begin--;
            }

        }
        System.out.println(begin);
        for (int i = begin; i >= 0; i--) {
            characters[i] = str.charAt(i);
        }
        System.out.println();
        return Arrays.toString(characters);
    }


    public static void main(String[] args) {
        String str = " we are family ";
        System.out.println(str);
        System.out.println(replaceAll(str, "%25"));

        System.out.println(str.replaceAll(" ", "%25"));
    }
}
