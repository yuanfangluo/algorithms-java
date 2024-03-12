package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 士兵过河 {
    /*
    *
    * 5
    * 130
    * 50 12 13 15 20
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int[] times = new int[n];
            for (int i = 0; i < n; i++) {
                times[i] = scanner.nextInt();
            }

            System.out.println(solution(n, t, times));
        }
    }

    private static String solution(int n, int t, int[] times) {
        // 士兵过河时间从小到大排序
        Arrays.sort(times);

        // 前i个人过河的累加时间
        int[] dp = new int[n];

        dp[0] = times[0];
        // 第一个士兵过河的时间大于敌军到达的时间
        if (dp[0] > t) return "0 0";

        dp[1] = getMax(times[0], times[1]);

        if (dp[1] > t) return  1 + "" + dp[0];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(
                    dp[i - 1] + times[0] + getMax(times[0],times[i] ),
                    dp[i - 2] + times[0] + getMax(times[i - 1], times[i])+ times[1] + getMax(times[0], times[1])
            );
            if (dp[i] > t) {
                return i + " " + dp[i- 1];
            }
        }

        return n + " " + dp[n - 1];
    }

    private static int getMax(int t1, int t2) { // 默认 t1 <= t2

        // 比较
        // 两个士兵坐船，一个士兵划船
        // 两个士兵坐船，两个都划船
        return Math.min(t1 * 10, t2);
    }


}
