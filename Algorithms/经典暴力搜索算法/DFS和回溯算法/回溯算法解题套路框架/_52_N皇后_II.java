package Algorithms.经典暴力搜索算法.DFS和回溯算法.回溯算法解题套路框架;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/n-queens-ii/
public class _52_N皇后_II {
    class Solution {
        int res = 0;

        public int totalNQueens(int n) {
            // '.' 表示空，'Q' 表示皇后，初始化空棋盘
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append('.');
                }
                board.add(sb.toString());
            }
            // 开始放置
            backtrack(board, 0);
            System.out.println(res);
            return res;
        }

        // 路径：board 中小于 row 的那些行都已经成功放置了皇后
        // 选择列表：第 row 行的所有列都是放置皇后的选择
        // 结束条件：row 超过 board 的最后一行
        void backtrack(List<String> board, int row) {
            // 触发结束条件
            if (row == board.size()) {
                res++;
                return;
            }

            int n = board.get(row).length();
            for (int col = 0; col < n; col++) {
                // 排除不合法选择
                if (!isValid(board, row, col)) {
                    continue;
                }
                // 做选择
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                // 进入下一行决策
                backtrack(board, row + 1);
                // 撤销选择
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }

        /* 是否可以在 board[row][col] 放置皇后？ */
        // 我们为什么不检查左下角，右下角和下方的格子，只检查了左上角，右上角和上方的格子呢？
        // 因为皇后是一行一行从上往下放的，所以左下方，右下方和正下方不用检查（还没放皇后）；
        // 因为一行只会放一个皇后，所以每行不用检查。也就是最后只用检查上面，左上，右上三个方向。
        boolean isValid(List<String> board, int row, int col) {
            int n = board.size();

            /* 检查列是否有皇后互相冲突 */
            for (int i = 0; i < n; i++) {
                if (board.get(i).charAt(col) == 'Q') {
                    return false;
                }
            }

            /* 检查右上方是否有皇后互相冲突 */
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }

            /* 检查左上方是否有皇后互相冲突 */
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }

            return true;
        }
    }
}
