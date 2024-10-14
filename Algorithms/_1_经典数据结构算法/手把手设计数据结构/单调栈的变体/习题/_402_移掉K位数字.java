package Algorithms._1_经典数据结构算法.手把手设计数据结构.单调栈的变体.习题;

import java.util.Stack;

// https://leetcode.cn/problems/remove-k-digits/
public class _402_移掉K位数字 {
    // 如果想让结果尽可能小，那么清除数字分两步：
    // 1、先删除 num 中的若干数字，使得 num 从左到右每一位都单调递增。比如 14329 转化成 129，这需要使用到 单调栈技巧。
    // 2、num 中的每一位变成单调递增的之后，如果 k 还大于 0（还可以继续删除）的话，则删除尾部的数字，比如 129 删除成 12。

    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Character> stk = new Stack<>();
            for (char c : num.toCharArray()) {
                // 单调栈代码模板
                while (!stk.isEmpty() && c < stk.peek() && k > 0) {
                    stk.pop();
                    k--;
                }
                // 防止 0 作为数字的开头
                if (stk.isEmpty() && c == '0') {
                    continue;
                }
                stk.push(c);
            }

            // 此时栈中元素单调递增，若 k 还没用完的话删掉栈顶元素
            while (k > 0 && !stk.isEmpty()) {
                stk.pop();
                k--;
            }

            // 若最后没剩下数字，就是 0
            if (stk.isEmpty()) {
                return "0";
            }
            
            // 将栈中字符转化成字符串
            StringBuilder sb = new StringBuilder();
            while (!stk.isEmpty()) {
                sb.append(stk.pop());
            }
            // 出栈顺序和字符串顺序是反的
            return sb.reverse().toString();
        }
    }

}
