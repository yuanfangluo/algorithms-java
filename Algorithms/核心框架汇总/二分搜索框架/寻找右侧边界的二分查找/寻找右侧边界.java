package Algorithms.核心框架汇总.二分搜索框架.寻找右侧边界的二分查找;

public class 寻找右侧边界 {
    // 左闭右开区间
    // 如果 target 不存在，搜索右侧边界的二分搜索返回的索引是小于 target 的最大索引。
    class Solution1 {
        int right_bound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1; // 注意
                    // 这样想: mid = left - 1
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }

            // 判断 target 是否存在于 nums 中
            // left - 1 索引越界的话 target 肯定不存在
            if (left - 1 < 0 || left - 1 >= nums.length) {
                return -1;
            }
            // 判断一下 nums[left] 是不是 target
            return nums[left - 1] == target ? (left - 1) : -1;
        }
    }

    // 左闭右闭区间
    class Solution2 {
        int right_bound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 这里改成收缩左侧边界即可
                    left = mid + 1;
                }
            }
            // 最后改成返回 left - 1
            if (left - 1 < 0 || left - 1 >= nums.length) {
                return -1;
            }
            return nums[left - 1] == target ? (left - 1) : -1;
        }
    }
}
