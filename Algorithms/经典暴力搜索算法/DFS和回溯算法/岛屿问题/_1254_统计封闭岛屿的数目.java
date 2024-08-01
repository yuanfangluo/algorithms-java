package Algorithms.经典暴力搜索算法.DFS和回溯算法.岛屿问题;

// https://leetcode.cn/problems/number-of-closed-islands/
public class _1254_统计封闭岛屿的数目 {
    // 注意这题规定 0 表示陆地，用 1 表示海水
    // 那么如何判断「封闭岛屿」呢？其实很简单，把上一题中那些靠边的岛屿排除掉，剩下的不就是「封闭岛屿」了吗？
    class Solution {
        // 主函数：计算封闭岛屿的数量
        int closedIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int j = 0; j < n; j++) {
                // 把靠上边的岛屿淹掉
                dfs(grid, 0, j);
                // 把靠下边的岛屿淹掉
                dfs(grid, m - 1, j);
            }

            for (int i = 0; i < m; i++) {
                // 把靠左边的岛屿淹掉
                dfs(grid, i, 0);
                // 把靠右边的岛屿淹掉
                dfs(grid, i, n - 1);
            }

            // 遍历 grid，剩下的岛屿都是封闭岛屿
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        // 从 (i, j) 开始，将与之相邻的陆地都变成海水
        void dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (grid[i][j] == 1) {
                // 已经是海水了
                return;
            }
            // 将 (i, j) 变成海水
            grid[i][j] = 1;
            // 淹没上下左右的陆地
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }

}
