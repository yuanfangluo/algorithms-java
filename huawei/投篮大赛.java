package huawei;

import java.util.Scanner;

public class 投篮大赛 {
    /*
    * 5 2 C D +
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        String[] ops = line.split(" ");
        int[] scores = new int[ops.length];
// 当前的位置
        int p = 0;
        for (String op: ops) {
            switch (op) {
                case "C":
                    if ( p > 0) {
                       scores[--p] = 0;
                    }
                    break;
                case "+":
                    if (p >0) {
                        int sum = 0;
                        for (int i = p-1; i >= 0 && i >= p - 2 ; i--) {
                            sum += scores[i];
                        }
                        scores[p] = sum;
                        p++;
                    }
                 break;
                case "D":
                    if (p>0){
                        scores[p] = 2 * scores[p-1];
                        p++;
                    }
                    break;
                default:
                    scores[p] = Integer.parseInt(op);
                    p++;
                    break;
            }
        }

        if (p == 0){
            return -1;
        }

        int sum = 0;
        for (int score:scores
             ) {
            sum += score;
        }
        return sum;
    }


}
