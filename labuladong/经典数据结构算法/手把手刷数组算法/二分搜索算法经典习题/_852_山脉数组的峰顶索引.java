package labuladong.经典数据结构算法.手把手刷数组算法.二分搜索算法经典习题;

/*
* https://leetcode.cn/problems/peak-index-in-a-mountain-array/?show=1
* 题目数据保证 arr 是一个山脉数组
* */
public class _852_山脉数组的峰顶索引 {

    // 
    public int peakIndexInMountainArray(int[] nums) {
        // 取两端都闭的二分搜索
        int left = 0, right = nums.length - 1;
        // 因为题目必然有解，所以设置 left == right 为结束条件
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // mid 本身就是峰值或其左侧有一个峰值
                right = mid;
            } else {
                // mid 右侧有一个峰值
                left = mid + 1;
            }
        }
        return left;
    }
}
