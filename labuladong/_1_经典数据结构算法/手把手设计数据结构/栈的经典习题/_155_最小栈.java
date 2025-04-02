package labuladong._1_经典数据结构算法.手把手设计数据结构.栈的经典习题;

import java.util.Stack;

// https://leetcode.cn/problems/min-stack/
public class _155_最小栈 {
    // 每个元素入栈时，还要记下来当前栈中的最小值。
    // 比方说，可以用一个额外的栈 minStk 来记录栈中每个元素入栈时的栈中的最小元素是多少，这样每次删除元素时就能快速得到剩余栈中的最小元素了
    // 原始思路
    class MinStack1 {
        // 记录栈中的所有元素
        Stack<Integer> stk = new Stack<>();
        // 阶段性记录栈中的最小元素
        Stack<Integer> minStk = new Stack<>();

        public void push(int val) {
            stk.push(val);
            // 维护 minStk 栈顶为全栈最小元素
            if (minStk.isEmpty() || val <= minStk.peek()) {
                // 新插入的这个元素就是全栈最小的
                minStk.push(val);
            } else {
                // 插入的这个元素比较大
                minStk.push(minStk.peek());
            }
        }

        public void pop() {
            stk.pop();
            minStk.pop();
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            // minStk 栈顶为全栈最小元素
            return minStk.peek();
        }
    }

    // 优化版
    class MinStack {
        // 记录栈中的所有元素
        Stack<Integer> stk = new Stack<>();
        // 阶段性记录栈中的最小元素
        Stack<Integer> minStk = new Stack<>();

        public void push(int val) {
            stk.push(val);
            // 维护 minStk 栈顶为全栈最小元素
            if (minStk.isEmpty() || val <= minStk.peek()) {
                // 新插入的这个元素就是全栈最小的
                minStk.push(val);
            }
        }

        public void pop() {
            // 注意 Java 的语言特性，比较 Integer 相等要用 equals 方法
            if (stk.peek().equals(minStk.peek())) {
                // 弹出的元素是全栈最小的
                minStk.pop();
            }
            stk.pop();
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            // minStk 栈顶为全栈最小元素
            return minStk.peek();
        }
    }
}
