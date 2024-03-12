package huawei;

import java.util.Scanner;
import java.util.TreeMap;

public class 区间交叠 {
    /*
    * 3
    * 1,4
    * 2,5
    * 3,6
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            scanner.nextLine();

            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] split = scanner.nextLine().split(",");
                points[i] = new int[]{Integer.parseInt(split[0], Integer.parseInt(split[1]))};
            }

            int res = solution(n, points);
            System.out.println(res);
        }
    }

    private static int solution(int n, int[][] points) {
        // TreeMap是以key升序的，HashMap是无序的
        TreeMap<Integer, Integer> line = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            for (int j = point[0]; j <= point[1] ; j++) {
                line.put(j, line.getOrDefault(j, 0) + 1);
            }
        }

        int del = 0;
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            boolean deletable = true;
            for (int j = point[0]; j <= point[1] ; j++) {
                if (line.get(j) <= 1){ // 至多只有一个
                    deletable = false;
                    break;
                }
            }

            if (deletable){
                for (int j = point[0]; j <= point[1] ; j++) {
                    line.put(j, line.get(j) - 1);
                }
                del++;
            }
        }
        return n - del;
    }
}
