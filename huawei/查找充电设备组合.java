package huawei;

import java.util.Scanner;

public class 查找充电设备组合 {
    /*
    * 4
    * 50 20 20 60
    * 90
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt(); // 充电设备个数
            int[] p = new int[n]; // 每个充电设备的输出功率
            for (int i = 0; i < n; i++) {
                p[i] = scanner.nextInt();
            }

            int p_max = scanner.nextInt(); // 充电站最大输出功率
            System.out.println(solution(n, p, p_max));
        }
    }

    public static int solution(int n, int[] p, int p_max) {
        // dp[i][j]:代表i台设备，最大输出功率为j的实际的最大功率
        int[][] dp = new int[n + 1][p_max + 1];

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= p_max ; j++) {
                // 如果没有设备或者最大输出功率为0，那结果还是0
                if (i == 0 || j == 0) continue;

                if (p[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j] , p[i - 1] + dp[i - 1][j - p[i - 1]]);
                }
            }
        }
        return dp[n][p_max];
    }

    /*
    * 经典算法：m个数中求n个数的算法
    * */
}
