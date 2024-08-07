// https://leetcode.cn/problems/spiral-matrix-ii/description/
public class _59_螺旋矩阵_II {
    int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        // 需要填入矩阵的数字
        int num = 1;
        while (num <= n * n) {
            if (top <= bottom) {
                // 在顶部从左向右遍历
                for (int j = left; j <= right; j++) {
                    matrix[top][j] = num++;
                }
                // 上边界下移
                top++;
            }

            if (left <= right) {
                // 在右侧从上向下遍历
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = num++;
                }
                // 右边界左移
                right--;
            }

            if (top <= bottom) {
                // 在底部从右向左遍历
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                // 下边界上移
                bottom--;
            }

            if (left <= right) {
                // 在左侧从下向上遍历
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                // 左边界右移
                left++;
            }
        }
        return matrix;
    }
}
