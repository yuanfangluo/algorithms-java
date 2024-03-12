package huawei;

import java.util.Scanner;

public class 分奖金 {
    /*
    * 3
    * 2 10 3
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] rands = new int[n];
            for (int i = 0; i < n; i++) {
                rands[i] = scanner.nextInt();
            }
            solution(rands);
        }
    }

    private static void solution(int[] rands) {
        for (int i = 0; i < rands.length; i++) {
            int ran = rands[i];
            boolean find = false;
            for (int j = i; j < rands.length; j++) {
                int other = rands[j];
                if (find = (other > ran)) { // 遇到第一个比自己大的数字
                    System.out.println((j - i) * (other - ran));
                    break;
                }
            }

            if (!find) {
                System.out.println(ran);
            }
        }
    }
}
