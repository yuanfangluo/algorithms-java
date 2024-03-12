package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 最小施肥机能效 {
    public static void main(String[] args) {
        /*
        * 5 7
        * 5 7 9 15 10
        * */
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt(); // 果园数
            int n = scanner.nextInt(); // 天数
            int[] fields = new int[m];
            for (int i = 0; i < m; i++) {
                fields[i] = scanner.nextInt();
            }
            int res = solution(m, n, fields);
            System.out.println(res);
        }
    }

    private static int solution(int m, int n, int[] fields) {
        if (m > n) { // 因为一天只能对一个果园施肥，如果果园树大于天数，肯定完成不了
            return -1;
        }

        Arrays.sort(fields);

        for (int k = fields[0]; k < fields[fields.length -1]; k++) {
            int days = 0;
            for (int field: fields) {
                int tmp = field;
                if (tmp <= k) {
                    days++;
                }else {
                    while (tmp > 0){
                        days++;
                        tmp -= k;
                    }
                }
                if (days > n) {
                    break;
                }
            }
            if (days == n){
                return k;
            }
        }
        return -1;
    }


}
