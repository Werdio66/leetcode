package com._520.leetcode._11_19;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IsValid {
    public boolean isValid(String s) {
        String str = s.trim();
        int len = str.length();
        if (str.equals(""))
            return true;
        if (len % 2 != 0)
            return false;

        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        if (!map.containsKey(str.charAt(0)))
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(str.charAt(i))){
                stack.push(str.charAt(i));
            }else {
                Character value = map.get(stack.pop());
                if (value != str.charAt(i))
                    return false;
            }

        }
        return stack.empty();
    }

    public static void main(String[] args) {
        IsValid i = new IsValid();
        System.out.println(i.isValid("(())<>{}[]"));
    }
}
