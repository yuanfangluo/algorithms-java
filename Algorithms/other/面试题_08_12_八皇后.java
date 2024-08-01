package Algorithms.other;

import java.util.ArrayList;
import java.util.List;
// https://leetcode-cn.com/problems/eight-queens-lcci/
public class 面试题_08_12_八皇后 {

    public static void main(String[] args) {
        System.out.println(new 面试题_08_12_八皇后().solveNQueens(8));
    }

    public List<List<String>> solveNQueens(int n) {
      return solveNQueens1(n);
    }

    List<List<String>> solveNQueens1(int n) {
        if (n < 1) return null;
        cols = new int[n];
        result = new ArrayList<>();
        place(0);
        return result;
    }

    List<List<String>> result;
    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] cols;

    /**
     * 从第row行开始摆放皇后
     * @param row
     */
    void place(int row) {
        if (row == cols.length) {
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            // 剪枝
            if (isValid(row, col)) {
                // 在第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 判断第row行第col列是否可以摆放皇后
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后
            if (cols[i] == col) {
                return false;
            }
            // 第i行的皇后跟第row行第col列格子处在同一斜线上
            if (row - i == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }

    void show() {
        List<String> item = new ArrayList<>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            item.add(sb.toString());
        }
        result.add(item);
    }
}




