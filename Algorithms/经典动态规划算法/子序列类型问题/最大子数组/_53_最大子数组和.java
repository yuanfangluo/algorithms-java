package Algorithms.经典动态规划算法.子序列类型问题.最大子数组;

// https://leetcode.cn/problems/maximum-subarray/
public class _53_最大子数组和 {

    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) return 0;
            int dp = nums[0];
            int max = dp;
            for (int i = 1; i < nums.length; i++) {
                // 状态转移方程
                if (dp <= 0){
                  dp =  nums[i];
                }else {
                  dp = dp + nums[i];
                }
                max = Math.max(max, dp);
            }
            return max;
        }
    }
}
