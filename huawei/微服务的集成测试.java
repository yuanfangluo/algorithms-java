package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 微服务的集成测试 {

    /*
    * 思路：拓扑排序
    * 有向无环图
    * */
    public static void main(String[] args) {

        /*
        * 3
        * 5 0 0
        * 1 5 0
        * 0 1 5
        * 3
        * */
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int k =scanner.nextInt();

            System.out.println(solution(matrix, n, k));
        }
        
    }

    private static int solution(int[][] matrix, int n, int k) {
        HashMap<Integer, ArrayList<Integer>> pre = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                pre.putIfAbsent(i, new ArrayList<>());
                if (matrix[i][j] == 1) {
                    pre.get(i).add(j);
                }
            }
        }
        
        return dfs(k -1, pre, matrix);
    }

    private static int dfs(int k, HashMap<Integer, ArrayList<Integer>> pre, int[][] matrix) {
        if (pre.get(k).size() == 0) {
            return matrix[k][k];
        }

        int maxPreTime = -1;
        for (Integer p: pre.get(k)
             ) {
            maxPreTime = Math.max(maxPreTime, dfs(p, pre, matrix));
        }
        return matrix[k][k] + maxPreTime;
    }


}
