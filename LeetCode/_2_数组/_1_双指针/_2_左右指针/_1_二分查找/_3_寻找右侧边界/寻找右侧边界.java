package LeetCode._2_数组._1_双指针._2_左右指针._1_二分查找._3_寻找右侧边界;

public class 寻找右侧边界 {
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 此时 left - 1 索引越界
        if (left - 1 < 0) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    int right_bound2(int[] nums, int target) {
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
        if (left - 1 < 0) return -1;
        return nums[left - 1] == target ? (left - 1) : -1;
    }

}
