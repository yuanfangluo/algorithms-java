package Algorithms._3_经典动态规划算法.玩游戏.魔塔;

import java.util.Arrays;

// https://leetcode.cn/problems/dungeon-game/
public class _174_地下城游戏 {
    // 自顶向下
    class Solution {
        /* 主函数 */
        public int calculateMinimumHP(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            // 备忘录中都初始化为 -1
            memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            return dp(grid, 0, 0);
        }

        // 备忘录，消除重叠子问题
        int[][] memo;

        /* 定义：从 (i, j) 到达右下角，需要的初始血量至少是多少 */
        int dp(int[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            // base case
            if (i == m - 1 && j == n - 1) {
                return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
            }

            if (i == m || j == n) {
                return Integer.MAX_VALUE;
            }

            // 避免重复计算
            if (memo[i][j] != -1) {
                return memo[i][j];
            }

            // 状态转移逻辑
            int res = Math.min(dp(grid, i, j + 1), dp(grid, i + 1, j)) - grid[i][j];
            // 骑士的生命值至少为 1
            memo[i][j] = res <= 0 ? 1 : res;

            return memo[i][j];
        }
    }
}