package labuladong.经典数据结构算法.手把手刷数组算法.二分搜索算法经典习题;

// https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?show=1
public class _33_搜索旋转排序数组 {
    // 【断崖】左侧的所有元素比右侧所有元素都大，我们是可以在这样一个存在断崖的山坡上用二分搜索算法搜索元素的
    // （1）确定 mid 中点落在「断崖」左侧还是右侧
    // （2）在第 1 步确定的结果之上，根据 target 和 nums[left], nums[right], nums[mid] 的相对大小收缩搜索区间
    // if (nums[mid] >= nums[left]) {
    //     // mid 落在断崖左边，此时 nums[left..mid] 有序
    // } else {
    //     // mid 落在断崖右边，此时 nums[mid..right] 有序
    // }

    public static int search(int[] nums, int target) {
        // 左右都闭的搜索区间
        int left = 0, right = nums.length - 1;
        // 因为是闭区间，所以结束条件为 left > right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 首先检查 nums[mid]，是否找到 target
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] >= nums[left]) {
                // mid 落在断崖左边，此时 nums[left..mid] 有序
                if (target >= nums[left] && target < nums[mid]) {
                    // target 落在 [left..mid-1] 中
                    right = mid - 1;
                } else {
                    // target 落在 [mid+1..right] 中
                    left = mid + 1;
                }
            } else {
                // mid 落在断崖右边，此时 nums[mid..right] 有序
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
        return -1;
    }
}
