package labuladong._1_经典数据结构算法.手把手刷数组算法.二分搜索算法核心代码模板.寻找左侧边界的二分搜索;

public class 寻找左侧边界 {
    class Solution1 {
        int left_bound(int[] nums, int target) {
            int left = 0;
            int right = nums.length; // 注意

            while (left < right) { // 注意
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid; // 注意
                }
            }
            // 如果 target 不存在，搜索左侧边界的二分搜索返回的索引是大于 target 的最小索引
            return left;
        }
    }

    // 如果 nums 中不存在 target 这个值，计算出来的这个索引含义是什么？如果我想让它返回 -1，怎么做？
    // 如果 target 不存在，搜索左侧边界的二分搜索返回的索引是大于 target 的最小索引
    class Solution2 {
        int left_bound(int[] nums, int target) {
            int left = 0;
            int right = nums.length; // 注意

            while (left < right) { // 注意
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid; // 注意
                }
            }

            // 如果索引越界，说明数组中无目标元素，返回 -1
            if (left < 0 || left >= nums.length) {
                return -1;
            }

            // 判断一下 nums[left] 是不是 target
            return nums[left] == target ? left : -1;
        }
    }
}
