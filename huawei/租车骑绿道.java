package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 租车骑绿道 {
    /*
    * 3 4
    * 3 2 2 1
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt(); // 限重
            int n = scanner.nextInt(); // 员工数
            int[] weights = new int[n]; // 员工体重
            for (int i = 0; i < n; i++) {
                weights[i] = scanner.nextInt();
            }
            int res = solution(m, n, weights);
            System.out.println(res);
        }
    }

    private static int solution(int m, int n, int[] weights) {
        int l = 0, r = n - 1;
        Arrays.sort(weights);
        int count = 0;
        while (r >= 1) {
            if (weights[r] > m) {
                r--;
                continue;
            }

            if (weights[l] + weights[r] <= m) {
                l++;
            }
            count++;
            r--;
        }
        return count;
    }

}
