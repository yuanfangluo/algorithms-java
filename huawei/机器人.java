package huawei;

import java.util.Scanner;

public class 机器人 {
    public static void main(String[] args) {

        /*
        * 4 4
        * 1 2 5 2
        * 2 4 4 5
        * 3 5 7 1
        * 4 6 2 4
        * */
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            int[][] matrix = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            solution(m, n, matrix);
            System.out.println(max);
        }

    }

    private static void solution(int m, int n, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                k = 1;
                find(matrix, visited, i, j);
                max= Math.max(k, max);
            }
        }
    }

    private static void find(int[][] matrix, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        for (int[] d: dic
             ) {
            int newI = i + d[0], newJ = j + d[1];
            if (newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length){
                if (!visited[newI][newJ] && Math.abs(matrix[i][j] - matrix[newI][newJ]) <= 1) {
                    k++;
                    find(matrix, visited, newI, newJ);
                }
            }
         }

    }

    private static final int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int max = 1;
    private static int k = 1;

}
