package huawei;

import java.util.Scanner;

public class 光伏场地建设规划 {
    public static void main(String[] args) {
        /*
        * 2 5 1 6
        * 1 3 4 5 8
        * 2 3 6 7 1
        * */
        try(Scanner scanner = new Scanner(System.in)){
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            int square = scanner.nextInt();
            int min = scanner.nextInt();

            int[][] matrix = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println(solution(matrix, row, column, square, min));
        }
    }

    private static int solution(int[][] matrix, int row, int column, int square, int min) {
        int zip_row = row - square + 1;
        int zip_column = column - square + 1;
        int[][] zip_col_dps = new int[row][zip_column];
        for (int i = 0; i < matrix.length; i++) {
            int[] rows = matrix[i];
            for (int j = 0; j < square; j++) {
                zip_col_dps[i][0] += rows[i];
            }

            for (int j = 1; j < zip_column; j++) {
                zip_col_dps[i][j] = zip_col_dps[i][j - 1] - rows[j - 1] + rows[j + square -1];
            }
        }

        matrix = zip_col_dps;

        int res = 0;

        int[][] zip_col_row_dps = new int[zip_row][zip_column];

        for (int j = 0; j < zip_column; j++) {
            for (int i = 0; i < square; i++) {
                zip_col_row_dps[0][j] += matrix[i][j];
            }
            if (zip_col_row_dps[0][j] >= min) res++;

            for (int i = 1; i < zip_row; i++) {
                zip_col_row_dps[i][j] = zip_col_dps[i-1][j] - matrix[i - 1][j] + matrix[i + square - 1][j];
                if (zip_col_row_dps[i][j] >= min) res++;
            }
        }

        return res;
    }
}
