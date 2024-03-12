package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 最短木板长度 {
    /*
    * 5 3 // 现在的木板个数，用来加长的木板
    * 4 5 3 5 5 // 现在每块木板的长度
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] lens = new int[n];
            for (int i = 0; i < lens.length; i++) {
                lens[i] = scanner.nextInt();
             }

            int maxLen = solution(n, m, lens);
            System.out.println(maxLen);
        }
    }

    /**
     *
     * @param n
     * @param m
     * @param lens
     * @return
     */
    private static int solution(int n, int m, int[] lens) {
        int maxLen = 0;
        Arrays.sort(lens);
        for (int i = 0; i < m; i++) {
            lens[0] = lens[0] + 1;
            Arrays.sort(lens);
            maxLen = Math.max(maxLen, lens[0]);
        }
        return maxLen;
    }
}
