package labuladong.经典暴力搜索算法.DFS和回溯算法.岛屿问题;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/number-of-islands/
public class _200_岛屿数量 {
    // 深度优先搜索dfs
    // 为什么每次遇到岛屿，都要用 DFS 算法把岛屿「淹了」呢？主要是为了省事，避免维护 visited 数组。
    // 因为 dfs 函数遍历到值为 0 的位置会直接返回，所以只要把经过的位置都设置为 0，就可以起到不走回头路的作用。
    class Solution {
        // 时间复杂度：O(MxN)，其中 M 和 N 分别为行数和列数。
        // 空间复杂度：O(MxN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 MxN。
        int numIslands(char[][] grid) {
            int res = 0;
            int m = grid.length, n = grid[0].length;
            // 遍历 grid
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        // 发现了一个岛屿
                        // 从 (i, j) 开始，将与之相邻的陆地都变成海水
                        // 注意：这里没有 visited 数组
                        // 因为 dfs 函数遍历到值为 0 的位置会直接返回，所以只要把经过的位置都设置为 0，就可以起到不走回头路的作用
                        // 这样，每次遇到岛屿，都要用 DFS 算法把岛屿「淹了」

                        // 每发现一个岛屿，岛屿数量加一
                        res++;
                        // 然后使用 DFS 将岛屿淹了
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        // 从 (i, j) 开始，将与之相邻的陆地都变成海水
        void dfs(char[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                // 超出索引边界
                return;
            }
            if (grid[i][j] == '0') {
                // 已经是海水了
                return;
            }
            // 将 (i, j) 变成海水
            grid[i][j] = '0';
            // 淹没上下左右的陆地
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }

    // 广度优先搜索 BFS，使用队列
    class Solution2 {
        int numIslands(char[][] grid) {
            int res = 0;
            int m = grid.length, n = grid[0].length;
            // 遍历 grid
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        grid[i][j] = 0;
                        Queue<Integer> queue = new LinkedList<>();
                        queue.offer(i * n + j );
                        while (!queue.isEmpty()) {
                            int id = queue.poll();
                            int row = id / n;
                            int col = id % n;
                            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                                queue.add((row - 1) * n + col);
                                grid[row - 1][col] = '0';
                            }
                            if (row + 1 < m && grid[row + 1][col] == '1') {
                                queue.add((row + 1) * n + col);
                                grid[row + 1][col] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                                queue.add(row * n + col - 1);
                                grid[row][col - 1] = '0';
                            }
                            if (col + 1 < n && grid[row][col + 1] == '1') {
                                queue.add(row * n + col + 1);
                                grid[row][col + 1] = '0';
                            }
                        }
                    }
                }
            }
            return res;
        }

        int encode(int row, int col, int cols) {
            return row * cols + col;
        }
    }
}
