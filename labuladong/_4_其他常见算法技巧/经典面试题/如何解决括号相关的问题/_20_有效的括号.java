package labuladong._4_其他常见算法技巧.经典面试题.如何解决括号相关的问题;

import java.util.HashMap;
import java.util.Stack;

// https://leetcode.cn/problems/valid-parentheses/
public class _20_有效的括号 {
    class Solution1 {
        public boolean isValid(String s) {
            if (s == null)
                return false;
            int n = s.length();
            if (n % 2 == 1)
                return false;
            HashMap<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    }

    class Solution2 {
        boolean isValid(String str) {
            Stack<Character> left = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    left.push(c);
                } else { // 字符 c 是右括号
                    if (!left.isEmpty() && leftOf(c) == left.peek()) {
                        left.pop();
                    } else {
                        // 和最近的左括号不匹配
                        return false;
                    }
                }
            }
            // 是否所有的左括号都被匹配了
            return left.isEmpty();
        }

        char leftOf(char c) {
            if (c == '}')
                return '{';
            if (c == ')')
                return '(';
            return '[';
        }
    }

}
