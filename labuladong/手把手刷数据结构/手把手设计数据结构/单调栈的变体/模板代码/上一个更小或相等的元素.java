package labuladong.手把手刷数据结构.手把手设计数据结构.单调栈的变体.模板代码;

import java.util.Stack;

public class 上一个更小或相等的元素 {
    // 计算 nums 中每个元素的上一个更小或相等元素
    int[] prevLessOrEqualElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 注意不等号
            while (!stk.isEmpty() && stk.peek() > nums[i]) {
                stk.pop();
            }
            // 现在栈顶就是 nums[i] 前面的更小或相等元素
            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }
        return res;
    }
}
