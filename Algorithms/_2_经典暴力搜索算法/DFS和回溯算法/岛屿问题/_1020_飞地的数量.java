package Algorithms._2_经典暴力搜索算法.DFS和回溯算法.岛屿问题;

// https://leetcode.cn/problems/number-of-enclaves/
public class _1020_飞地的数量 {
    // 1 代表陆地，0 代表海水：
    class Solution {
        int numEnclaves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            // 淹掉靠边的陆地
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n - 1);
            }
            for (int j = 0; j < n; j++) {
                dfs(grid, 0, j);
                dfs(grid, m - 1, j);
            }

            // 数一数剩下的陆地
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res += 1;
                    }
                }
            }
            return res;
        }

        // 和之前的实现类似
        void dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 0) {
                return;
            }
            grid[i][j] = 0;
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
