package Algorithms._1_经典数据结构算法.手把手设计数据结构.单调栈的变体.模板代码;

import java.util.Stack;

public class 上一个更小的元素 {
    // 计算 nums 中每个元素的上一个更小的元素
    int[] prevLessElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 把 nums[i] 之前的较大元素删除
            while (!stk.isEmpty() && stk.peek() >= nums[i]) {
                stk.pop();
            }
            // 现在栈顶就是 nums[i] 前面的更小元素
            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }
        return res;
    }
}
