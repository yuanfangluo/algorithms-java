package labuladong._3_经典动态规划算法.玩游戏.最小路径和;

// https://leetcode.cn/problems/minimum-path-sum/
public class _64_最小路径和 {
    class Solution {
        public int minPathSum(int[][] grid) {

            int rows = grid.length;
            int cols = grid[0].length;

            int[][] dp = new int[rows][cols];

            dp[0][0] = grid[0][0];

            // 第0行
            for (int col = 1; col < cols; col++) {
                dp[0][col] = dp[0][col - 1] + grid[0][col];
            }

            // 第0列
            for (int row = 1; row < rows; row++) {
                dp[row][0] = dp[row - 1][0] + grid[row][0];
            }

            for (int row = 1; row < rows; row++) {
                for (int col = 1; col < cols; col++) {
                    dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
                }
            }

            return dp[rows - 1][cols - 1];
        }
    }
}
