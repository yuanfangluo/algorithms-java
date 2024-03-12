package huawei;

import java.util.*;

public class 查找单入口空闲区域 {
    static int n;
    static int m;
    static String[][] matrix;

    static int[][] offset = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static HashSet<String> checked = new HashSet<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            n = scanner.nextInt();
            m = scanner.nextInt();

            matrix = new String[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = scanner.next();
                }
            }
            String res = solution(matrix, n, m);
            System.out.println(res);
        }
    }

    private static String solution(String[][] matrix, int n, int m) {
        ArrayList<Integer[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("O".equals(matrix[i][j]) && !checked.contains(i + "-" + j)){
                    ArrayList<Integer[]> enter = new ArrayList<>();
                    int count = dfs(i, j, 0, enter);
                    if (enter.size() == 1){
                        Integer[] pos = enter.get(0);
                        Integer[] an = {pos[0], pos[1], count};
                        ans.add(an);
                    }

                }
            }
        }

        if (ans.size() == 0) return "NULL";
        ans.sort((a,b) -> b[2] - a[2]);

        if (ans.size() == 1 || ans.get(0)[2] > ans.get(1)[2]){
            StringJoiner sj = new StringJoiner(" ", "", "");
            for (Integer ele:
                 ans.get(0)) {
                sj.add(ele + "");
            }
            return sj.toString();
        }else {
            return ans.get(0)[2] + "";
        }
    }

    private static int dfs(int i, int j, int count, ArrayList<Integer[]> enter) {
        String pos = i + "-" + j;
        if (i < 0 || i >= n || j < 0 || j >= m || "X".equals(matrix[i][j]) || checked.contains(pos)){
            return count;
        }

        checked.add(pos);

        if (i == 0 || i == n - 1 || j == 0 || j == m - 1) enter.add(new Integer[]{i, j});

        count++;
        for (int k = 0; k < offset.length; k++) {
            int offsetX = offset[k][0];
            int offsetY = offset[k][1];

            int newI = i + offsetX;
            int newJ = j + offsetY;
            count = dfs(newI, newJ, count, enter);
        }
        return count;
    }
}
