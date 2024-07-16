package labuladong.手把手刷数据结构.手把手刷数组算法.一个方法团灭nSum问题.两数之和;

import java.util.Arrays;

public class twoSum问题 {
    // 参数 nums 是长度为 n 的数组，target 是目标值
    // 返回长度为 2 的数组，表示 nums 中恰好有两个元素的和为 target
    public int[] twoSum(int[] nums, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        // 左右指针
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 根据 sum 和 target 的比较，移动左右指针
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else if (sum == target) {
                return new int[] { nums[lo], nums[hi] };
            }
        }
        return new int[] {};
    }
}
