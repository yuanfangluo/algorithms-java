package huawei;

import java.util.Scanner;

public class 开心消消乐 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt(); // 行数
            int m = scanner.nextInt(); // 列数

            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int res = solution(n, m, arr);
            System.out.println(res);
        }
    }

    private static int solution(int n, int m, int[][] arr) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    click(i, j, arr);
                    res++;
                }
            }
        }

    return res;
    }

    private static void click(int r, int c, int[][] arr) {
        if ( r >= 0 && r < arr.length && c >= 0 && c < arr[0].length){
            if (arr[r][c] == 1){
                arr[r][c] = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        click(r + i, c + j, arr);
                    }
                }
            }
        }
    }


}
