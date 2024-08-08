// https://leetcode.cn/problems/unique-paths-ii/
public class _63_不同路径_II {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            obstacleGrid[0][0] = 1;

            int[][] dp = new int[m][n];
            // dp[i][j] 表示从 (0, 0) 到 (i, j) 的路径数
            // 初始化第一行
            // 因为只能从左方到达第一行的位置，因此第一行的位置的路径数等于 1
            // 但是如果第一行的位置有障碍物，那么第一行的位置的路径数等于 0
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                }
                dp[0][j] = 1;
            }
            // 初始化第一列
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                }
                dp[i][0] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        continue;
                    }
                    // 状态转移方程
                    // 只能从左方或者上方到达当前位置
                    // 因此当前位置的路径数等于上方位置的路径数加上左方位置的路径数
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }
}
