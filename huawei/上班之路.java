package huawei;

import java.util.HashSet;
import java.util.Scanner;

public class 上班之路 {
    static int t, c, n, m;
    static String[][] matrix;

    public static void main(String[] args) {
        /*
         * 2 0
         * 5 5
         * ..S..
         * *****
         * T....
         * ****.
         * .....
         * */
        try (Scanner scanner = new Scanner(System.in)) {
            t = scanner.nextInt();
            c = scanner.nextInt();
            scanner.nextLine();
            n = scanner.nextInt();
            m = scanner.nextInt();
//            System.out.printf("拐弯次数t：%d, 消除路障次数c：%d, 行数n：%d, 列数m：%d,", t, c, n, m);
            matrix = new String[n][m];
            for (int i = 0; i < n; i++) {
                matrix[i] = scanner.next().split("");
            }
            System.out.println(solution());
        }

    }

    private static String solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("S".equals(matrix[i][j])) {
                    HashSet<Integer> path = new HashSet<>();
                    path.add(i * m + j);
                    return dfs(i, j, 0, 0, 0, path) ? "YES" : "NO";
                }
            }
        }
        return "NO";
    }


    static int[][] offsets = {{-1, 0, 1}, {1, 0, 2}, {0, -1, 3}, {0, 1, 4}};

    private static boolean dfs(int si, int sj, int ut, int uc, int lastDirect, HashSet<Integer> path) {
        if ("T".equals(matrix[si][sj])) {
            return true;
        }

        for (int[] offset : offsets) {
            int direct = offset[2];
            int newI = si + offset[0];
            int newJ = sj + offset[1];

            boolean flag1 = false;
            boolean flag2 = false;

            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                int pos = newI * m + newJ;
                if (path.contains(pos)) continue;

                if (lastDirect != 0 && lastDirect != direct) {
                    if (ut + 1 > t) continue;
                    flag1 = true;
                }

                if ("*".equals(matrix[newI][newJ])) {
                    if (uc + 1 > c) continue;
                    flag2 = true;
                }

                path.add(pos);

                boolean res = dfs(newI, newJ, ut + (flag1 ? 1 : 0), uc + (flag2 ? 1 : 0), direct, path);

                if (res) return true;
                path.remove(pos);

            }
        }
        return false;
    }


}
