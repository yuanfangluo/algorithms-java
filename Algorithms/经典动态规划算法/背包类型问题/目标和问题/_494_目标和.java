package Algorithms.经典动态规划算法.背包类型问题.目标和问题;

// https://leetcode.cn/problems/target-sum/
public class _494_目标和 {
    // 方法1、回溯算法。算法复杂度高

    // 方法2、针对回溯算法，做优化，使用备忘录

    // 方法3、
    // 如果我们把 nums 划分成两个子集 A 和 B，分别代表分配 + 的数和分配 - 的数
    // sum(A) - sum(B) = target
    // sum(A) = target + sum(B)
    // sum(A) + sum(A) = target + sum(B) + sum(A)
    // 2 * sum(A) = target + sum(nums)
    // 可以推出 sum(A) = (target + sum(nums)) / 2，
    // 也就是把原问题转化成：nums 中存在几个子集 A，使得 A 中元素的和为 (target + sum(nums)) / 2？
    // if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
    // return 0;
    // }

    class Solution3 {
        int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int n : nums) sum += n;
            // 这两种情况，不可能存在合法的子集划分
            if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
                return 0;
            }
            return subsets(nums, (sum + target) / 2);
        }
        
        /* 计算 nums 中有几个子集的和为 sum */
        int subsets(int[] nums, int sum) {
            int n = nums.length;
            int[][] dp = new int[n + 1][sum + 1];
            // base case
            dp[0][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j >= nums[i - 1]) {
                        // 两种选择的结果之和
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    } else {
                        // 背包的空间不足，只能选择不装物品 i
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][sum];
        }
    }

    // 方法4:空间优化成一维 dp
    // 只要把 dp 数组的第一个维度全都去掉就行了，唯一的区别就是这里的 j 要从后往前遍历
    // 在计算新的 dp[j] 的时候，dp[j] 和 dp[j-nums[i-1]] 还是上一轮外层 for 循环的结果。
    class Solution4 {
        int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int n : nums) sum += n;
            // 这两种情况，不可能存在合法的子集划分
            if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
                return 0;
            }
            return subsets(nums, (sum + target) / 2);
        }
        /* 计算 nums 中有几个子集的和为 sum */
        int subsets(int[] nums, int sum) {
            int n = nums.length;
            int[] dp = new int[sum + 1];
            // base case
            dp[0] = 1;

            for (int i = 1; i <= n; i++) {
                // j 要从后往前遍历
                for (int j = sum; j >= 0; j--) {
                    // 状态转移方程
                    if (j >= nums[i - 1]) {
                        dp[j] = dp[j] + dp[j - nums[i - 1]];
                    } else {
                        dp[j] = dp[j];
                    }
                }
            }
            return dp[sum];
        }
    }

    // 总结一下:
    // 回溯算法虽好，但是复杂度高，即便消除一些冗余计算，也只是「剪枝」，没有本质的改进。
    // 而动态规划就比较玄学了，经过各种改造，从一个加减法问题变成子集问题，又变成背包问题，经过各种套路写出解法，
    // 又搞出空间压缩，还得反向遍历。

}
