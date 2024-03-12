package huawei;

import java.util.Scanner;
import java.util.StringJoiner;

public class 信号发射和接收 {
    /*
    * 1 6
    * 2 4 1 5 3 3
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt(); // 行数
            int n = scanner.nextInt(); // 列数
            int[][] anth = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    anth[i][j] = scanner.nextInt();
                }
            }

            System.out.println(solution(anth, m, n));
        }
    }


    private static String solution(int[][] anth, int m, int n) {
        int[][] ret= new int[m][n];
        // 先处理南向发射信号
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                for (int k = i + 1; k < m; k++) {
                    // 接收天线anth[k][j] 不高于中间天线anth[k - 1][j]，否则无法接收信号
                 if (k - i > 1 && anth[k][j] <= anth[k - 1][j]) continue;
                 ret[k][j]++;
                 // 发射天线anth[i][j] 不高于接收天线anth[k][j],则必然无法发射信号到anth[k+1][j],则不需要进入

                    if (anth[i][j] <= anth[k][j])
                        break;
                }
            }
        }

        StringJoiner joiner = new StringJoiner(" ");
        // 再处理东向发射信号
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (k - j > 1 && anth[i][k] <= anth[i][k - 1]) continue;
                    ret[i][k]++;
                    if (anth[i][j] <= anth[i][k]) break;
                }
                joiner.add(ret[i][j] + "");
            }
        }

        return m + " " + n + "\n" + joiner;
    }
}
