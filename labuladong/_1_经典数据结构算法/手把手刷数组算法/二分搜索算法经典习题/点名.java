package labuladong._1_经典数据结构算法.手把手刷数组算法.二分搜索算法经典习题;

// https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/description/
// 0～n-1中缺失的数字
public class 点名 {
    public int missingNumber(int[] nums) {
        // 搜索左侧的二分搜索
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                // mid 和 nums[mid] 不对应，说明左边有元素缺失
                right = mid - 1;
            } else {
                // mid 和 nums[mid] 对应，说明元素缺失在右边
                left = mid + 1;
            }
        }
        return left;
    }
}
