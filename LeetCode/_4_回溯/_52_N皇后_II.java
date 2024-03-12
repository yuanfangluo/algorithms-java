package LeetCode._4_回溯;

// https://leetcode-cn.com/problems/n-queens-ii/
public class _52_N皇后_II {
    public int totalNQueens(int n) {
        return new _51_N皇后().solveNQueens(n).size();
    }
}
