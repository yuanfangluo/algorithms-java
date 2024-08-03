package Algorithms._1_经典数据结构算法.手把手设计数据结构.单调栈的变体.模板代码;

import java.util.Stack;

public class 下一个更小或相等的元素 {
    // 计算 nums 中每个元素的下一个更小或相等的元素
    int[] nextLessOrEqualElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 删掉 nums[i] 后面较大的元素
            while (!stk.isEmpty() && stk.peek() > nums[i]) {
                stk.pop();
            }
            // 现在栈顶就是 nums[i] 身后的更小或相等元素
            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }
        return res;
    }
}
