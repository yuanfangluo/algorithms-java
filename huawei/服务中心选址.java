package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 服务中心选址 {
    /*
    * 3
    * 1 2
    * 3 4
    * 10 20
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();

            int[][] points = new int[n][2];

            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }

            int res = solution(n, points);
            System.out.println(res);
        }

    }

    private static int solution(int n, int[][] points) {
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            int a = points[i][0];
            int b = points[i][1];
            if (i == 0){
                pos[i] = b;
            } else if (i == n - 1) {
                pos[i] = a;
            } else {
                if (i < n / 2){
                    pos[i] = b;
                } else {
                    pos[i] = a;
                }
            }
        }

        // 排序
        Arrays.sort(pos);

        // 最佳位置
        int po = -1;
        if (n % 2 == 0){
            po = (n - 1) / 2;
        } else {
            po = n / 2;
        }

        // 计算距离
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i != po){
                result += Math.abs(pos[i] - pos[po]);
            }
        }

        return result;
    }


}
