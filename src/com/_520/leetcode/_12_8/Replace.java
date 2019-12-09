package com._520.leetcode._12_8;

import java.util.Arrays;

public class Replace {
    private static String replaceSpace(StringBuffer str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                stringBuilder.append("%20");
            else
                stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("f fffffff")));
    }
}
