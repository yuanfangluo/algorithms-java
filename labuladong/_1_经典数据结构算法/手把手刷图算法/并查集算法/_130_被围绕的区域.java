package labuladong._1_经典数据结构算法.手把手刷图算法.并查集算法;

import labuladong.Base.UF;

// https://leetcode.cn/problems/surrounded-regions/
public class _130_被围绕的区域 {
    // 这个问题应该归为 岛屿系列问题 使用 DFS 算法解决：
    // 先用 for 循环遍历棋盘的四边，用 DFS 算法把那些与边界相连的 O 换成一个特殊字符，比如 #；
    // 然后再遍历整个棋盘，把剩下的 O 换成 X，把 # 恢复成 O。
    // 这样就能完成题目的要求，时间复杂度 O(MN)。

    // 二维坐标 (x,y) 可以转换成 x * n + y 这个数（m 是棋盘的行数，n 是棋盘的列数），
    // 敲黑板，这是将二维坐标映射到一维的常用技巧。
    
    class Solution {
        void solve(char[][] board) {
            if (board.length == 0)
                return;
                
            int m = board.length;
            int n = board[0].length;
            // 给 dummy 留一个额外位置
            UF uf = new UF(m * n + 1);
            int dummy = m * n;
            // 将首列和末列的 O 与 dummy 连通
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O')
                    uf.union(i * n, dummy);
                if (board[i][n - 1] == 'O')
                    uf.union(i * n + n - 1, dummy);
            }
            // 将首行和末行的 O 与 dummy 连通
            for (int j = 0; j < n; j++) {

                if (board[0][j] == 'O')
                    uf.union(j, dummy);
                if (board[m - 1][j] == 'O')
                    uf.union(n * (m - 1) + j, dummy);
            }
            // 方向数组 d 是上下左右搜索的常用手法
            int[][] d = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
            for (int i = 1; i < m - 1; i++)
                for (int j = 1; j < n - 1; j++)
                    if (board[i][j] == 'O')
                        // 将此 O 与上下左右的 O 连通
                        for (int k = 0; k < 4; k++) {
                            int x = i + d[k][0];
                            int y = j + d[k][1];
                            if (board[x][y] == 'O')
                                uf.union(x * n + y, i * n + j);
                        }
            // 所有不和 dummy 连通的 O，都要被替换
            for (int i = 1; i < m - 1; i++)
                for (int j = 1; j < n - 1; j++)
                    if (!uf.connected(dummy, i * n + j))
                        board[i][j] = 'X';
        }
    }

}
