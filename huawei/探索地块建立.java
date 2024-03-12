package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 探索地块建立 {
    /*
    * 发电量满足目标电量k的地块数量
    * 2 5 2 6
    * 1 3 4 5 8
    * 2 3 6 7 1
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt(); // 行
            int m = scanner.nextInt(); // 列
            int c = scanner.nextInt(); // 正方形边长为c的发电站
            int k = scanner.nextInt(); // 目标发电量

            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println(matrix);
            int res = solution(matrix, k, c);
            System.out.println(res);
        }
    }

    private static int solution(int[][] matrix, int k, int c) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] s = new int[n + 1][m + 1];

        // 生成前缀和子矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // s[i][j] 表示以[i, j] 作为矩阵最右下角的最大矩阵的前缀和
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j- 1];
            }
        }

        int res = 0;
        for (int i = c; i <= n; i++) {
            for (int j = c; j <= m ; j++) {
                if (s[i][j] - s[i - c][j] - s[i][j - c] + s[i - c][j-c] >= k){
                    res++;
                }
            }
        }
        return res;
    }
}
