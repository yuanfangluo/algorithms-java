package Algorithms.经典数据结构算法.手把手设计数据结构.哈希表更多习题;

// https://leetcode.cn/problems/majority-element/
public class _169_多数元素 {
    class Solution {
        public int majorityElement(int[] nums) {
            // 我们想寻找的那个众数
            int target = 0;
            // 计数器（类比带电粒子例子中的带电性）
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    // 当计数器为 0 时，假设 nums[i] 就是众数
                    target = nums[i];
                    // 众数出现了一次
                    count = 1;
                } else if (nums[i] == target) {
                    // 如果遇到的是目标众数，计数器累加
                    count++;
                } else {
                    // 如果遇到的不是目标众数，计数器递减
                    count--;
                }
            }
            
            // 回想带电粒子的例子
            // 此时的 count 必然大于 0，此时的 target 必然就是目标众数
            return target;
        }
    }
}
