package huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class 最多等和不相交连续子序列 {
    /*
    *
    * 10
    * 8 8 9 1 9 6 3 9 1 0
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] seq = new int[n];
            for (int i = 0; i < n; i++) {
                seq[i] = scanner.nextInt();
            }
            int res = solution(seq, n);
            System.out.println(res);
        }
    }

    private static int solution(int[] seq, int n) {
        int max = 0;
        int[] dp = new int[n];
        System.arraycopy(seq, 0, dp, 0, n);
        Map<Integer, Integer> sumCount = new HashMap<>();
        Map<Integer, HashSet<Integer>> sumPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (i > 0) {
                    dp[j] = dp[j] + seq[j + 1];
                }

                int sum = dp[j];

                if (!sumCount.containsKey(sum)) {
                    sumCount.put(sum, 0);
                    sumPos.put(sum, new HashSet<>());
                }

                boolean exists = false;
                HashSet<Integer> poss = sumPos.get(sum);
                for (int k = j; k <= j + i ; k++) {
                    if (exists = poss.contains(k)) {
                        break;
                    }
                }

                if (!exists){
                    int newSum = sumCount.get(sum) + 1;
                    sumCount.put(sum, newSum);
                    max = Math.max(max, newSum);
                    for (int k = j; k <= j + i ; k++) {
                        poss.add(k);
                    }
                    sumPos.put(sum,poss);
                }
            }
        }
        return max;
    }
}
