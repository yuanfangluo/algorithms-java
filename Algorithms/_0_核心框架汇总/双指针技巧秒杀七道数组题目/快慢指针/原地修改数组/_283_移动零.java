package Algorithms._0_核心框架汇总.双指针技巧秒杀七道数组题目.快慢指针.原地修改数组;

// https://leetcode.cn/problems/move-zeroes/
public class _283_移动零 {
    // 让我们将所有 0 移到最后，其实就相当于移除 nums 中的所有 0，然后再把后面的元素都赋值为 0 即可
    class Solution {
        public void moveZeroes(int[] nums) {
            // 去除 nums 中的所有 0，返回不含 0 的数组长度
            int p = removeElement(nums, 0);
            // 将 nums[p...] 的元素赋值为 0
            for (; p < nums.length; p++) {
                nums[p] = 0;
            }
        }

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
