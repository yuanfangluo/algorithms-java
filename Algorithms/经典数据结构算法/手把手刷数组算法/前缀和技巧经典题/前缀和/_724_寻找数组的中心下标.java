package Algorithms.经典数据结构算法.手把手刷数组算法.前缀和技巧经典题.前缀和;

/*
* https://leetcode.cn/problems/find-pivot-index/
*
* */
public class _724_寻找数组的中心下标 {
    // 这道题考察前文讲的 前缀和技巧，有了前缀和数组 preSum，就可以根据 preSum 快速计算 nums 中任意位置的左侧元素和右侧元素之和了
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
        // 根据前缀和判断左半边数组和右半边数组的元素和是否相同
        for (int i = 1; i < preSum.length; i++) {
            // preSum索引 i-1 相当于nums的i
            // 所以计算 nums[i-1] 左侧和右侧的元素和
            int leftSum = preSum[i - 1] - preSum[0];
            int rightSum = preSum[n] - preSum[i];
            if (leftSum == rightSum) {
                // 相对 nums 数组，preSum 数组有一位索引偏移
                // preSum 的 i-1 相当于nums的 i
                return i - 1;
            }
        }
        return -1;
    }
}
