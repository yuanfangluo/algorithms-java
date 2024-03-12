package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 日志限流 {
    /*
    * 6
    * 3 3 8 7 10 15
    * 40
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int[] records = new int[n];
            for (int i = 0; i < n; i++) {
                records[i] = scanner.nextInt();
            }

            int total = scanner.nextInt();

            System.out.println(solution(n, records, total));
        }
    }

    private static int solution(int n, int[] records, int total) {
        // 累加
        int sum = Arrays.stream(records)
                .reduce(Integer::sum)
                .getAsInt();

        if (sum <= total) return -1;

        Arrays.sort(records);

        int max_limit = records[records.length - 1];
        int min_limit = total / n;

        int ans = min_limit;

        while (max_limit - min_limit > 1){
            int limit = (max_limit + min_limit)>>1;

            int tmp = 0;

            for (int record: records
                 ) {
                tmp += Math.min(record, limit);
            }

            if (tmp > total){
                max_limit = limit;
            }else if (tmp < total){
                min_limit = limit;
                ans = limit;
            } else {
                return limit;
            }
        }

        return ans;
    }


}
