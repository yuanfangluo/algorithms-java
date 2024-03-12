package huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 最大报酬 {
    public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)){
        int T = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] ts = new int[n][2];
        for (int i = 0; i < n; i++) {
            ts[i][0] = scanner.nextInt();
            ts[i][1] = scanner.nextInt();
        }

        int res = solution(T, n, ts);
        System.out.println(res);
    }
    }

    private static int solution(int T, int n, int[][] ts) {
        int res = 0;
        List<int[]> list = Arrays.stream(ts).sorted((e1, e2) -> {
            double r1 = 1. * e1[1] / e1[0];
            double r2 = 1. * e2[1] / e2[0];
            int diffR = (int) (r1 - r2);
            if (diffR == 0){
                return  e1[0] - e2[0];
            } else return diffR;

        }).collect(Collectors.toList());

        int sumTime = 0;
        for (int[] job:
             list) {
            if (job[0] + sumTime > T){
                continue;
            }
            sumTime += job[0];
            res += job[1];
        }
        return res;
    }

}
