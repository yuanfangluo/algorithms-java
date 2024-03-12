package huawei;

import java.math.BigInteger;
import java.util.Scanner;

public class 对称美学 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int t = scanner.nextInt();
            long[][] cases = new long[t][2];
            for (int i = 0; i < t; i++) {
                cases[i][0] = scanner.nextLong();
                cases[i][1] = scanner.nextLong();
            }
            solution(t, cases);
        }
    }

    private static void solution(int t, long[][] cases) {
        for (int i = 0; i < t; i++) {
            long n = cases[i][0];
            long k = cases[i][1];
            String res = find(n - 1, k) == 'R' ? "red" : "blue";
            System.out.println(res);
        }
    }

    private static char find(long n, long k) {
        if ( n == 0){
            return 'R';
        }

        // 第n行的长度
        long len = BigInteger.valueOf(2).pow((int) n).longValue();

        // 如k在后半段，，则和前一个字符串相同
        if (k >= len /2) {
            long pos = k - len/2;
            return find(n- 1, pos);
        } else {
            // 如果k 在前半段，则与前一个字符串相反
            return find(n-1, k) == 'R' ? 'B' : 'R';
        }

    }


}
