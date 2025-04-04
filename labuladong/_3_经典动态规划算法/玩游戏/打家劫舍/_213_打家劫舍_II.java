package labuladong._3_经典动态规划算法.玩游戏.打家劫舍;

// https://leetcode.cn/problems/house-robber-ii/
public class _213_打家劫舍_II {
    class Solution1 {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            return Math.max(robRange(nums, 0, n - 2), 
                            robRange(nums, 1, n - 1));
        }
    
        // 仅计算闭区间 [start,end] 的最优结果
        int robRange(int[] nums, int start, int end) {
            int dp_i_1 = 0, dp_i_2 = 0;
            int dp_i = 0;
            for (int i = end; i >= start; i--) {
                dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i;
        }
    }
}
