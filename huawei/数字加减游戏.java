package huawei;

import java.util.Scanner;

public class 数字加减游戏 {
    public static void main(String[] args) {

        /*
        * 使用多少次a才能将原来数字变为目标数字
        * 1 10 5 2
        * */
        try(Scanner scanner = new Scanner(System.in)){
            int s = scanner.nextInt(); // 原来数字
            int t = scanner.nextInt(); // 目标数字
            int a = scanner.nextInt(); //
            int b = scanner.nextInt(); // 没有使用限制

            int res = solution(s, t, a, b);
            System.out.println(res);
        }

    }

    private static int solution(int s, int t, int a, int b) {
        int diff = Math.abs(s - t);
        int min1 = 0;
        int tmp = diff;

        while (tmp % b != 0) {
            tmp -= a;
            min1++;
        }

        tmp = diff;

        int min2 = 0;

        while (tmp % b != 0) {
            tmp += a;
            min2++;
        }

        return Math.min(min1, min2);
    }


}
