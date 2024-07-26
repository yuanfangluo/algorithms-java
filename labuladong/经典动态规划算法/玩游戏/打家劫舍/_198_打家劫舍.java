package labuladong.经典动态规划算法.玩游戏.打家劫舍;

import java.util.Arrays;

// https://leetcode.cn/problems/house-robber/
public class _198_打家劫舍 {
    // 解决动态规划问题就是找「状态」和「选择」，仅此而已。
    // 在每间房子前都有两种选择：抢或者不抢

    class Solution1 {
        public int rob(int[] nums) {
            return dp(nums, 0);
        }

        // 返回 nums[start..] 能抢到的最大值
        private int dp(int[] nums, int start) {
            if (start >= nums.length) {
                return 0;
            }

            int res = Math.max(
                    // 不抢，去下家
                    dp(nums, start + 1),
                    // 抢，去下下家
                    nums[start] + dp(nums, start + 2));
            return res;
        }
    }

    // 有重复字问题，需要优化,使用备忘录
    class Solution2 {

        private int[] memo;

        // 主函数
        public int rob(int[] nums) {
            // 初始化备忘录
            memo = new int[nums.length];
            Arrays.fill(memo, -1);
            // 强盗从第 0 间房子开始抢劫
            return dp(nums, 0);
        }

        // 返回 dp[start..] 能抢到的最大值
        private int dp(int[] nums, int start) {
            if (start >= nums.length) {
                return 0;
            }
            // 避免重复计算
            if (memo[start] != -1)
                return memo[start];

            int res = Math.max(
                    dp(nums, start + 1),
                    dp(nums, start + 2) + nums[start]);
            // 记入备忘录
            memo[start] = res;
            return res;
        }
    }

    // 我们也可以略作修改，写出自底向上的解法
    // dp[i] = x 表示：从第 i 间房子开始抢劫，最多能抢到的钱为 x
    class Solution3 {
        int rob(int[] nums) {
            int n = nums.length;
            // dp[i] = x 表示：
            // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
            // base case: dp[n] = 0
            int[] dp = new int[n + 2];
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
            }
            return dp[0];
        }
    }

    // 我们又发现状态转移只和 dp[i] 最近的两个状态有关，所以可以进一步优化，将空间复杂度降低到 O(1)。

    class solution4 {
        int rob(int[] nums) {
            int n = nums.length;
            // 记录 dp[i+1] 和 dp[i+2]
            int dp_i_1 = 0, dp_i_2 = 0;
            // 记录 dp[i]
            int dp_i = 0; 
            for (int i = n - 1; i >= 0; i--) {
                dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i;
        }
    }

    // 从后往前偷
    class Solution5 {
        public int rob(int[] nums) {
            // 从后往前偷
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
    
            int first = nums[0];
            int second = Math.max(nums[0], nums[1]);
    
            for (int i = 2; i < nums.length; i++) {
                int tmp = second;
                second = Math.max(nums[i] + first, second);
                first = tmp; 
            }
            
            return second;
        }
    }

}
