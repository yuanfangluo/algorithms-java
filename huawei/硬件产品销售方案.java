package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 硬件产品销售方案 {
    /*
    * 500
    * [100, 200, 300, 500]
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt();
            scanner.nextLine();
            String line = scanner.nextLine();
            String[] strs = line.substring(1, line.length() - 1).split(", ");
            int n = strs.length;
            int[] A = new int[n];

            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(strs[i]);
            }

            System.out.println(solution(A, m));

        }
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    private static List<List<Integer>> solution(int[] A, int m) {
        int size = A.length;
        if (size == 0){
            return res;
        }

        dfs(A, 0, size, m);

        return res;
    }

    private static void dfs(int[] A, int begin, int size, int m) {
        if (m < 0){
            return;
        }

        if (m == 0){
            List<Integer> tmp = new ArrayList<>(path);
            res.add(tmp);
            return;
        }

        for (int i = begin; i < size; i++) {
            path.add(A[i]);
            dfs(A, i, size, m - A[i]);
            path.remove(path.size() - 1);
        }
    }
}
