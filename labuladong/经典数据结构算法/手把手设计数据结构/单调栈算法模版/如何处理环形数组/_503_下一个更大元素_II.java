package labuladong.经典数据结构算法.手把手设计数据结构.单调栈算法模版.如何处理环形数组;

import java.util.Stack;

// https://leetcode.cn/problems/next-greater-element-ii/
public class _503_下一个更大元素_II {
    // 我们可以不用构造新数组，而是利用循环数组的技巧来模拟数组长度翻倍的效果。
    int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();

        // 数组长度加倍模拟环形数组
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 索引 i 要求模，其他的和模板一样
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }

            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }
}
