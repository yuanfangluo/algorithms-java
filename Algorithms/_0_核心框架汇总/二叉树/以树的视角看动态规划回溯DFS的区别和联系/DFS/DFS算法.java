package Algorithms._0_核心框架汇总.二叉树.以树的视角看动态规划回溯DFS的区别和联系.DFS;

public class DFS算法 {
    // DFS 算法核心逻辑
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        // 遍历过的每个格子标记为 0
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    // DFS 算法把「做选择」「撤销选择」的逻辑放在 for 循环外面
    void dfs(Node root) {
    if (root == null) return;
    // 做选择
    print("我已经进入节点 %s 啦", root)
    for (Node child : root.children) {
        dfs(child);
    }
    // 撤销选择
    print("我将要离开节点 %s 啦", root)
}
}
