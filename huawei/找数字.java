package huawei;

import java.util.*;

public class 找数字 {
    public static void main(String[] args) {
        /*
         * 3
         * 5
         * 0 3 5 4 2
         * 2 5 7 8 3
         * 2 5 4 2 4
         * */
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] ints = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ints[i][j] = scanner.nextInt();
                }
            }
            String res = solution(ints, n, m);
            System.out.println(res);
        }
    }

    private static String solution(int[][] ints, int n, int m) {
        Map<Integer, List<int[]>> numPos = new HashMap<>();

        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = ints[i][j];
                if (!numPos.containsKey(num)){
                    numPos.put(num, new ArrayList<>());
                }
                numPos.get(num).add(new int[]{i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            resList.add(new ArrayList<>());
            List<Integer> curList = resList.get(i);

            for (int j = 0; j < m; j++) {
                int num = ints[i][j];
                List<int[]> allPos = numPos.get(num);
                if (allPos.size() == 1){ // 表示只有一个值
                    curList.add(-1);
                    continue;
                }

                // 这边表示有相同的值
                int min = Integer.MAX_VALUE;
                for (int[] pos: allPos) {
                    if (i == pos[0] && j == pos[1]){ // 表示就是当前值，pass
                        continue;
                    }

                    int diff = Math.abs(i - pos[0]) + Math.abs(j - pos[1]);
                    min = Math.min(min,diff);
                }
                curList.add(min);
            }

        }
        return resList.toString();
    }


}
