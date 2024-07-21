package labuladong.手把手刷数据结构.手把手设计数据结构.单调栈的变体.模板代码;

import java.util.Stack;

public class 上一个更大元素 {
    // 计算 nums 中每个元素的上一个更大元素
    int[] prevGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        // 因为是求 nums[i] 前面的元素，所以正着往栈里放
        for (int i = 0; i < n; i++) {
            // 删掉 nums[i] 前面较小的元素
            while (!stk.isEmpty() && stk.peek() <= nums[i]) {
                stk.pop();
            }
            // 现在栈顶就是 nums[i] 前面的更大元素
            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }
        return res;
    }
}
