package Algorithms.经典数据结构算法.手把手刷数组算法.前缀和数组.一维数组中的前缀和;

/*
* https://leetcode.cn/problems/range-sum-query-immutable/
*
* */
public class _303_区域和检索_数组不可变 {

    class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            // preSum[i] 代表 nums[0]+...+nums[i-1]
            preSum = new int[nums.length + 1];
            
            // 计算 nums 的累加和
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        // 查询闭区间 [left, right] 的累加和
        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}

// sumRange 函数仅仅需要做一次减法运算，避免了每次进行 for 循环调用，最坏时间复杂度为常数 O(1)。
// 这个技巧在生活中运用也挺广泛的，比方说，你们班上有若干同学，每个同学有一个期末考试的成绩（满分 100 分），那么请你实现一个
// API，输入任意一个分数段，返回有多少同学的成绩在这个分数段内。
