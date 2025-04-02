package labuladong._1_经典数据结构算法.手把手刷数组算法.二维数组的花式遍历技巧.顺逆时针旋转矩阵;

/*
* https://leetcode.cn/problems/rotate-image/
*
* */
public class _48_旋转图像 {

    // 我们可以先将 n x n 矩阵 matrix 按照左上到右下的对角线进行镜像对称：
    // 然后再对矩阵的每一行进行反转：
    public void rotate11(int[][] matrix) {

    }

    // 将二维矩阵原地顺时针旋转 90 度
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
