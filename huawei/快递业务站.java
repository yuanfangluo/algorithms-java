package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 快递业务站 {
    /*
    * 4
    * 1 1 0 0
    * 1 1 0 0
    * 0 0 1 0
    * 0 0 0 1
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int res = solution(n, matrix);
            System.out.println(res);
        }
    }

    private static int solution(int n, int[][] matrix) {
        int count = 0;
        Set<Integer> cover = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!cover.contains(i)){
                count++;
            }
            int[] site = matrix[i];

            for (int j = 0; j < site.length; j++) {
                if (site[j] == 1){
                    cover.add(j);
                }
            }
        }

        return count;
    }


}
