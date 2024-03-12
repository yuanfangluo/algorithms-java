package huawei;

import java.util.Scanner;

public class 核酸检测安排 {
    /*
    * 采集员和志愿者的安排
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int N = scanner.nextInt();
            int V = scanner.nextInt();
            scanner.nextLine();
            int [] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }

            int res = solution(N, nums, V);
            System.out.println(res);

        }
    }

    private static int solution(int N, int[] nums, int V) {
        // 采集员浮动效率数
        int[] arrM = new int[N];
        for (int i = 0; i < N; i++) {
            arrM[i] = nums[i] / 10;
        }

        int[][] dp = new int[N + 1][V + 1];
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            count += nums[i - 1] - 2 * arrM[i - 1];
            // 没有志愿者的采样效率
            dp[i][0] = count;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1]- 2 * arrM[i - 1], dp[i - 1][j - 1] + nums[i - 1]);
                dp[i][j] = Math.max(dp[i][j], j - 2 >= 0 ? dp[i - 1][j - 2] + nums[i - 1] + arrM[i - 1] : 0);
                dp[i][j] = Math.max(dp[i][j], j - 3 >= 0 ? dp[i - 1][j - 3] + nums[i - 1] + 2 * arrM[i - 1] : 0);
                dp[i][j] = Math.max(dp[i][j], j - 4 >= 0 ? dp[i - 1][j - 4] + nums[i - 1] + 3 * arrM[i - 1] : 0);

            }
        }
        return dp[N][V];
    }


}
