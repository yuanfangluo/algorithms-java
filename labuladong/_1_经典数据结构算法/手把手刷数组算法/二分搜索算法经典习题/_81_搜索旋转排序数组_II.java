package labuladong._1_经典数据结构算法.手把手刷数组算法.二分搜索算法经典习题;

/*
* https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/?show=1
* 在计算 mid 之前收缩 left, right 边界，提前消除重复元素
* 这样 mid 必然出现在山坡上，不会和 nums[left], nums[right] 相等，
* 然后就可以正常执行第 2 步逻辑，和第 33 题的解法完全相同了
* */
public class _81_搜索旋转排序数组_II {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 本题需要在计算 mid 之前收缩左右边界去重
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            while (left < right && nums[right - 1] == nums[right]) {
                right--;
            }

            // 其余逻辑和第 33 题完全相同
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[left]) { // mid 落在断崖左边，此时 nums[left..mid] 有序
                if (target >= nums[left] && target < nums[mid]) {
                    // target 落在 [left..mid-1] 中
                    right = mid - 1;
                } else {
                    // target 落在 [mid+1..right] 中
                    left = mid + 1;
                }
            } else { // mid 落在断崖右边，此时 nums[mid..right] 有序
                if (target <= nums[right] && target > nums[mid]) {
                    // target 落在 [mid+1..right] 中
                    left = mid + 1;
                } else {
                    // target 落在 [left..mid-1] 中
                    right = mid - 1;
                }
            }
        }
        // while 结束还没找到，说明 target 不存在
        return false;
    }

}
