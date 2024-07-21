package labuladong.手把手刷数据结构.手把手设计数据结构.单调栈的变体.习题;

import java.util.Stack;

// https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
public class _1475_商品折扣后的最终价格 {
    // 计算下一个更小或相等的元素
    class Solution {
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] res = new int[n];
            // 下一个小于等于 price[i] 的价格就是优惠券折扣
            int[] nextElement = nextLessOrEqualElement(prices);
            for (int i = 0; i < prices.length; i++) {
                // 如果存在优惠券，则减少相应的价格
                if (nextElement[i] != -1) {
                    res[i] = prices[i] - nextElement[i];
                } else {
                    res[i] = prices[i];
                }
            }
            return res;
        }

        // 单调栈模板：计算 nums 中每个元素的下一个更小或相等的元素
        int[] nextLessOrEqualElement(int[] nums) {
            int n = nums.length;
            // 存放答案的数组
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            // 倒着往栈里放
            for (int i = n - 1; i >= 0; i--) {
                // 删掉 nums[i] 后面较大的元素
                while (!s.isEmpty() && s.peek() > nums[i]) {
                    s.pop();
                }
                // 现在栈顶就是 nums[i] 身后的更小或相等元素
                res[i] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i]);
            }
            return res;
        }
    }

}
