package labuladong._1_经典数据结构算法.手把手设计数据结构.单调栈的变体.习题;

import java.util.Stack;

// https://leetcode.cn/problems/number-of-visible-people-in-a-queue/
public class _1944_队列中可以看到的人数 {
    // 靠左的高个子可以把靠右相邻的矮个子都「挤掉」，相当于计算下一个更大元素
    // 只不过这道题不是问你下一个更大元素是多少，而是问你当前元素和下一个更大元素之间的元素个数

    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] res = new int[n];
            // int[] 记录 {身高，小于等于该身高的人数} 二元组
            Stack<Integer> stk = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                // 记录右侧比自己矮的人
                int count = 0;
                // 单调栈模板，计算下一个更大或相等元素（身高）
                while (!stk.isEmpty() && heights[i] > stk.peek()) {
                    stk.pop();
                    count++;
                }
                
                // 不仅可以看到比自己矮的人，如果后面存在更高的的人，也可以看到这个高人
                res[i] = stk.isEmpty() ? count : count + 1;
                stk.push(heights[i]);
            }
            return res;
        }
    }
}
