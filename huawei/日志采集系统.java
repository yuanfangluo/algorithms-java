package huawei;

import java.util.Map;
import java.util.Scanner;

public class 日志采集系统 {
    /*
    *
    * 1 98 1
    * 50 60 1
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        int score = 0;
        String[] split = line.split(" ");
        int[] counts = new int[split.length];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = Integer.parseInt(split[i]);
        }
        // 如果第一个时刻有超过100条的记录
        if (counts.length >0 && counts[0] >= 100) {
            return 100;
        }

        // 第一个时刻没有100条的记录
        for (int i = 0; i < counts.length; i++) {
            score = Math.max(score, getScore(counts, i));
        }

        return score;

    }

    private static int getScore(int[] counts, int ts) {

        int score= 0;
        int total = 0;

        for (int i = 0; i <= ts ; i++) {
            if (total + counts[i] < 100){
                score += counts[i];
                score -= counts[i] * (ts - i);
                total += counts[i];
            } else {
              int diff = 100;
                for (int j = 0; j < i; j++) {
                    diff -= counts[j];
                    counts[j] = 0;

                }
                counts[i] -= diff;
                score += diff;
                score -= diff*(ts -i);
                return score;
            }
        }
        return score;
    }


}
