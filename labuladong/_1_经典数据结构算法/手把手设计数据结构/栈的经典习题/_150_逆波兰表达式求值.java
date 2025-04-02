package labuladong._1_经典数据结构算法.手把手设计数据结构.栈的经典习题;

import java.util.Stack;

// https://leetcode.cn/problems/evaluate-reverse-polish-notation/
public class _150_逆波兰表达式求值 {
    // tokens = ["2","1","+","3","*"]
    // 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

    // 逆波兰表达式：

    // 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。

    // 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
    // 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
    // 逆波兰表达式主要有以下两个优点：

    // 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
    // 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
    class Solution {
        private boolean isOperator(String token) {
            return "+-*/".contains(token);
        }

        private int calculate(Integer right, Integer left, String operator) {
            switch (operator) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                default:
                    return left / right;
            }
        }

        public int evalRPN(String[] tokens) {
            // 首先，逆波兰表达式相当于后面的数字先运算，我们可以想到使用栈这个数据结构
            // 解题思路
            // 1、遇见数字，直接入栈
            // 2、遇见符号：
            // (1)弹出栈顶的右操作数
            // (2)弹出栈顶的左操作数
            // (3)使用符号进行计算，将计算结果入栈
            // 最后栈中的唯一数字就是后缀表达式的计算值

            Stack<Integer> stack = new Stack<Integer>();

            for (String token : tokens) {
                if (isOperator(token)) {
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(calculate(right, left, token));
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }
}
