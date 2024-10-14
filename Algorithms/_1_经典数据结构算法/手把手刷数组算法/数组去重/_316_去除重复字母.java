package Algorithms._1_经典数据结构算法.手把手刷数组算法.数组去重;

import java.util.Stack;

// https://leetcode.cn/problems/remove-duplicate-letters/
public class _316_去除重复字母 {
    // 在向栈 stk 中插入字符 'a' 的这一刻，我们的算法需要知道，字符 'a' 的字典序和之前的两个字符 'b' 和 'c' 相比，谁大谁小？
    // 如果当前字符 'a' 比之前的字符字典序小，就有可能需要把前面的字符 pop 出栈，让 'a' 排在前面，对吧？
    // 我们的算法在 stk.peek() > c 时才会 pop 元素，其实这时候应该分两种情况：
    // 情况一、如果 stk.peek() 这个字符之后还会出现，那么可以把它 pop 出去，反正后面还有嘛，后面再 push 到栈里，刚好符合字典序的要求
    // 情况二、如果 stk.peek() 这个字符之后不会出现了，前面也说了栈中不会存在重复的元素，那么就不能把它 pop 出去，否则你就永远失去了这个字符。

    class Solution {
        public String removeDuplicateLetters(String s) {
            Stack<Character> stk = new Stack<>();
            // 维护一个计数器记录字符串中字符的数量
            // 因为输入为 ASCII 字符，大小 256 够用了
            int[] count = new int[256];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
            }

            boolean[] inStack = new boolean[256];
            for (char c : s.toCharArray()) {
                // 每遍历过一个字符，都将对应的计数减一
                count[c]--;

                if (inStack[c]) {
                    continue;
                }

                while (!stk.isEmpty() && stk.peek() > c) {
                    // 若之后不存在栈顶元素了，则停止 pop
                    if (count[stk.peek()] == 0) {
                        break;
                    }
                    // 若之后还有，则可以 pop
                    inStack[stk.pop()] = false;
                }

                stk.push(c);
                inStack[c] = true;
            }

            StringBuilder sb = new StringBuilder();
            while (!stk.empty()) {
                sb.append(stk.pop());
            }
            return sb.reverse().toString();
        }
    }
}
