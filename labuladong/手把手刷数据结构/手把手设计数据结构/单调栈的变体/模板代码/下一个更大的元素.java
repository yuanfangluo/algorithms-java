package labuladong.手把手刷数据结构.手把手设计数据结构.单调栈的变体.模板代码;

import java.util.Stack;

public class 下一个更大的元素 {
    // 计算 nums 中每个元素的下一个更大元素
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        // 因为是求 nums[i] 后面的元素，所以倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 删掉 nums[i] 后面较小的元素
            while (!stk.isEmpty() && stk.peek() <= nums[i]) {
                stk.pop();
            }
            // 现在栈顶就是 nums[i] 身后的更大元素
            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }
        return res;
    }
}
