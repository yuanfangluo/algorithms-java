package huawei;

import java.util.Scanner;

public class 递增字符串 {
    /*
    * AABBA
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.next();
            System.out.println(solution(line));
        }
    }

    private static int solution(String str) {
        int n = str.length();

//        将B全去掉
        String replaceAll =  str.replaceAll("B", "");

        int A = replaceAll.length();
        
        int dp = 0;

        if (str.charAt(0) == 'A') dp = 1;
        
        int res = check(0, dp, A - dp);

        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == 'A') dp += 1;
            res = Math.min(res, check(i, dp, A - dp));
        }
        return res;
    }

    /**
     *
     * @param idx
     * @param LM_A
     * @param R_A
     * @return
     */
    private static int check(int idx, int LM_A, int R_A) {
        return idx + 1 - LM_A + R_A;
    }
}
