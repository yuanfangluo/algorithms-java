package labuladong._0_核心框架汇总.双指针技巧秒杀七道数组题目.快慢指针.原地修改数组;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
public class _26_删除有序数组中的重复项 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    // 维护 nums[0..slow] 无重复
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            // 数组长度为索引 + 1
            return slow + 1;
        }
    }
}
