package labuladong.经典数据结构算法.手把手刷数组算法.二维数组的花式遍历技巧.顺逆时针旋转矩阵;

public class 矩阵逆时针旋转90度 {
    // 另一条对角线镜像对称矩阵，然后再反转每一行，就得到了逆时针旋转矩阵的结果

    // 将二维矩阵原地逆时针旋转 90 度
    void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 沿左下到右上的对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                // swap(matrix[i][j], matrix[n-j-1][n-i-1])
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    void reverse(int[] arr) {
        /* 见上文 */}
}
