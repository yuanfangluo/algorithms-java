package labuladong.经典数据结构算法.手把手设计数据结构.单调栈算法模版.下一个更大元素;

import java.util.Stack;

// https://leetcode.cn/problems/daily-temperatures/
public class _739_每日温度 {
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            if (T == null || T.length == 0)
                return null;
            int[] result = new int[T.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < T.length; i++) {
                // 这里应该要写大于，不要写大于等于
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
            return result;
        }
    }

    int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // 这里放元素索引，而不是元素
        Stack<Integer> s = new Stack<>();
        /* 单调栈模板 */
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            // 得到索引间距
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            // 将索引入栈，而不是元素
            s.push(i);
        }
        return res;
    }
}
