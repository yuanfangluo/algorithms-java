package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 最佳对手 {
    /*
    *
    * 6 30 // 队伍个数 允许最大实力差距
    * 81 87 47 59 81 18 // 队伍实力
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(solution(n, d, arr));
        }
    }

    private static int solution(int n, int d, int[] arr) {
        // 1. 首先是排序
        Arrays.sort(arr);

        // 奇数
        int odd_count = 0;
        int odd_total = 0;
        // 偶数
        int even_count = 0;
        int even_total = 0;

        // 相邻差距超过最大差距，导致没有结果
        boolean failure = true;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff <= d){
                failure = false;
                if (i % 2 == 0){
                    odd_count++;
                    odd_total += diff;
                }else {
                    even_count++;
                    even_total += diff;
                }
            }
        }

        if (failure){
            return -1;
        }

        if (odd_count > even_count){
            return odd_total;
        }

        if (odd_count < even_count){
            return even_total;
        }

        return Math.min(odd_total, even_total);
    }
}
