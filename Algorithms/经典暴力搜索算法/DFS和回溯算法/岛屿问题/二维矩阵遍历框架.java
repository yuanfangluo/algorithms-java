package Algorithms.经典暴力搜索算法.DFS和回溯算法.岛屿问题;

public class 二维矩阵遍历框架 {
    // 二维矩阵遍历框架
    // 因为二维矩阵本质上是一幅「图」，所以遍历的过程中需要一个 visited 布尔数组防止走回头路
    class Solution1 {
        void dfs(int[][] grid, int i, int j, boolean[][] visited) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                // 超出索引边界
                return;
            }

            if (visited[i][j]) {
                // 已遍历过 (i, j)
                return;
            }

            // 进入节点 (i, j)
            visited[i][j] = true;
            dfs(grid, i - 1, j, visited); // 上
            dfs(grid, i + 1, j, visited); // 下
            dfs(grid, i, j - 1, visited); // 左
            dfs(grid, i, j + 1, visited); // 右
        }
    }

    // 处理二维数组的常用小技巧，你有时会看到使用「方向数组」来处理上下左右的遍历
    class Solution2 {
        // 方向数组，分别代表上、下、左、右
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        void dfs(int[][] grid, int i, int j, boolean[][] visited) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                // 超出索引边界
                return;
            }
            if (visited[i][j]) {
                // 已遍历过 (i, j)
                return;
            }

            // 进入节点 (i, j)
            visited[i][j] = true;
            // 递归遍历上下左右的节点
            for (int[] d : dirs) {
                int next_i = i + d[0];
                int next_j = j + d[1];
                dfs(grid, next_i, next_j, visited);
            }
            // 离开节点 (i, j)
        }
    }
}
