package Algorithms.经典数据结构算法.手把手设计数据结构.栈的经典习题;

import java.util.HashMap;
import java.util.Stack;

// https://leetcode.cn/problems/valid-parentheses/ 
public class _20_有效的括号 {
    class Solution {
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
}
