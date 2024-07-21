package labuladong.other;

/*
* https://leetcode.cn/problems/search-insert-position/description/?show=1
*
* */
public class _35_搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        return left_bound(nums, target);
    }

    // 搜索左侧边界的二分算法
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
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
        return left;
    }
}
