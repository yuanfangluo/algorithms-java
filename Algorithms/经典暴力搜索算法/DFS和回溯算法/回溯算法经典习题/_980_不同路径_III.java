package Algorithms.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

// https://leetcode.cn/problems/unique-paths-iii/
public class _980_不同路径_III {
    class Solution {
        int res = 0;
        boolean[][] visited;
        int visitedCount = 0;
        int totalCount = 0;

        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        public int uniquePathsIII(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            visited = new boolean[m][n];
            int startI = 0, startJ = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 找起点
                    if (grid[i][j] == 1) {
                        startI = i;
                        startJ = j;
                    }
                    // 统计所有非障碍的个数
                    if (grid[i][j] == 1 || grid[i][j] == 0) {
                        totalCount++;
                    }
                }
            }
            dfs(grid, startI, startJ);
            return res;
        }

        // 从起点开始，搜索所有可行的路径
        // 当搜索到终点时，统计可行的路径数
        void dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            // 剪枝，索引越界
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }

            // 剪枝，跳过障碍物、已访问的格子
            if (grid[i][j] == -1 || visited[i][j]) {
                return;
            }

            // 到达终点
            if (grid[i][j] == 2) {
                if (visitedCount == totalCount) {
                    res++;
                }
                return;
            }

            visited[i][j] = true;
            visitedCount++;

            for (int[] dir : dirs) {
                dfs(grid, i + dir[0], j + dir[1]);
            }

            visited[i][j] = false;
            visitedCount--;
        }
    }
}
