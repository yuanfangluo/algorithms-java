package labuladong.经典数据结构算法.手把手刷数组算法.二分搜索算法核心代码模板.寻找一个数;

/*
* https://leetcode.cn/problems/binary-search/description/
* 分析二分查找的一个技巧是：不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节
* */
public class _704_二分查找 {
    public int search(int[] nums, int target) {
        // [left, right],zuo
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 小技巧：防止left + right太大，导致溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
               right = mid -1;
            }
        }
        return -1;
    }
}
