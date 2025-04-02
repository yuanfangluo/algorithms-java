package labuladong._1_经典数据结构算法.手把手刷数组算法.一个方法团灭nSum问题.两数之和;

/*
* https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
*
* */
public class _167_两数之和_II_输入有序数组 {
    int[] twoSum(int[] nums, int target) {
        // 一左一右两个指针相向而行
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // 题目要求的索引是从 1 开始的
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // 让 sum 大一点
            } else if (sum > target) {
                right--; // 让 sum 小一点
            }
        }
        // 到这里代表 left == right，而题目要求必须是两个索引，不能使用相同的元素
        return new int[]{-1, -1};
    }
    
}
