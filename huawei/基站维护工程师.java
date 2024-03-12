package huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 基站维护工程师 {

    /*
    * 3
    * 0 2 1
    * 1 0 2
    * 2 1 0
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
                System.out.println(solution(matrix, n));
            }
    }

    private static int solution(int[][] matrix, int n) {
        boolean[] used = new boolean[n];
        LinkedList<Integer> path = new LinkedList<>();
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        dfs(n, used, path, res);

        int ans = Integer.MAX_VALUE;
        for (LinkedList<Integer> pa: res
             ) {
            int dis = matrix[0][pa.get(0)];
            for (int i = 0; i < pa.size() - 1; i++) {
                int p = pa.get(i);
                int c = pa.get(i + 1);
                dis += matrix[p][c];
            }
            dis += matrix[pa.getLast()][0];
            ans = Math.min(ans, dis);
        }
        return ans;
    }

    private static void dfs(int n, boolean[] used, LinkedList<Integer> path, ArrayList<LinkedList<Integer>> res) {
        if (path.size() == n-1){
            res.add((LinkedList<Integer>) path.clone());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]){
                path.push(i);
                used[i] = true;
                dfs(n, used, path, res);
                used[i] = false;
                path.pop();
            }
        }

    }


}
