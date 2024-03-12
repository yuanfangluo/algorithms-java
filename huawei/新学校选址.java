package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 新学校选址 {
    /*
    *
    * 5
    * 0 20 40 10 30
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int[] sites = new int[n];
            for (int i = 0; i < n; i++) {
                sites[i] = scanner.nextInt();
            }

            int bestSite = solution(sites);
            System.out.println(bestSite);
        }
    }

    private static int solution(int[] sites) {
        Arrays.sort(sites);
        if ((sites.length & 1) == 0){ // 偶数
            return sites[(sites.length >> 1) -1];
        } else {
            return sites[sites.length >> 1];
        }
    }
}


