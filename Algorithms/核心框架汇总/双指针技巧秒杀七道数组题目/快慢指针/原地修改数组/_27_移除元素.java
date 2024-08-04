package Algorithms.核心框架汇总.双指针技巧秒杀七道数组题目.快慢指针.原地修改数组;

// https://leetcode.cn/problems/remove-element/
public class _27_移除元素 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
