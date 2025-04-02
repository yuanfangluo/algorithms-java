package labuladong._1_经典数据结构算法.手把手刷数组算法.二维数组的花式遍历技巧.矩阵的螺旋遍历;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/spiral-matrix/
public class _54_螺旋矩阵 {

    // 解题的核心思路是：
    // 在顶部从左向右遍历
    // 在右侧从上向下遍历
    // 在底部从右向左遍历
    // 在左侧从下向上遍历
    List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int top_index = 0, bottom_index = m - 1;
        int left_index = 0, right_index = n - 1;
        List<Integer> res = new ArrayList<>();
        // res.size() == m * n 则遍历完整个数组
        while (res.size() < m * n) {
            if (top_index <= bottom_index) {
                // 在顶部从左向右遍历
                for (int j = left_index; j <= right_index; j++) {
                    res.add(matrix[top_index][j]);
                }
                // 上边界下移
                top_index++;
            }

            if (left_index <= right_index) {
                // 在右侧从上向下遍历
                for (int i = top_index; i <= bottom_index; i++) {
                    res.add(matrix[i][right_index]);
                }
                // 右边界左移
                right_index--;
            }

            if (top_index <= bottom_index) {
                // 在底部从右向左遍历
                for (int j = right_index; j >= left_index; j--) {
                    res.add(matrix[bottom_index][j]);
                }
                // 下边界上移
                bottom_index--;
            }

            if (left_index <= right_index) {
                // 在左侧从下向上遍历
                for (int i = bottom_index; i >= top_index; i--) {
                    res.add(matrix[i][left_index]);
                }
                // 左边界右移
                left_index++;
            }
        }
        return res;
    }

}
