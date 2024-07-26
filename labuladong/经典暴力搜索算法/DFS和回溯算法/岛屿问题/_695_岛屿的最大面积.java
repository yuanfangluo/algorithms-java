package labuladong.经典暴力搜索算法.DFS和回溯算法.岛屿问题;

// https://leetcode.cn/problems/max-area-of-island/
public class _695_岛屿的最大面积 {
    // 这题的大体思路和之前完全一样，只不过 dfs 函数淹没岛屿的同时，还应该想办法记录这个岛屿的面积。
    class Solution {
        int maxAreaOfIsland(int[][] grid) {
            // 记录岛屿的最大面积
            int res = 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        // 淹没岛屿，并更新最大岛屿面积
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        // 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
        int dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                // 超出索引边界
                return 0;
            }
            if (grid[i][j] == 0) {
                // 已经是海水了
                return 0;
            }
            // 将 (i, j) 变成海水
            grid[i][j] = 0;
            return dfs(grid, i + 1, j)
                    + dfs(grid, i, j + 1)
                    + dfs(grid, i - 1, j)
                    + dfs(grid, i, j - 1) + 1;
        }
    }
}
