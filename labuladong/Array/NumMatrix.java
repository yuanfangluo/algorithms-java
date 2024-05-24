package labuladong.Array;

public class NumMatrix {
    private int[][] preSum; // preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i - 1, j - 1]的元素和

    public NumMatrix(int[][] matrix) {
        int col = matrix.length, row = matrix[0].length;
        if ( col == 0 || row == 0) return;

        // 构造前缀和矩阵
        preSum = new int[col + 1][row + 1];
        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= row; j++) {
                // 计算元素和
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i - 1][j - 1] - preSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}
