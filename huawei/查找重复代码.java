package huawei;

import java.util.Scanner;

public class 查找重复代码 {
    /*
    * 最长公共子串
    * hello123world
    * hello123abc4
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(solution(str1, str2));
        }
    }

    private static String solution(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        // 存放长度
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        String ans = "";
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j -1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max){
                        max = dp[i][j];
                        ans = str1.substring(i - max, i);
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
