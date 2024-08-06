package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 模拟商城优惠打折 {
    /*
    * 3 2 5
    * 3
    * 100
    * 200
    * 400
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
//            List<Integer> params = Arrays.stream(scanner.nextLine().split(" "))
//                    .map(Integer::parseInt)
//                    .toList();
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int x = scanner.nextInt();
            System.out.println("end");

            int[] prices = new int[x];
            for (int i = 0; i < x; i++) {
                prices[i] = scanner.nextInt();
            }

            solution(m, n, k, prices);
    }
    }

    private static void solution(int m, int n, int k, int[] prices) {

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            // 一共有四种优惠方式
            int[][] result = new int[4][2];

            result[0] = mode_a(price, m, n);
            result[1] = mode_b(price, m, n);
            result[2] = mode_c(price, m, k);
            result[3] = mode_d(price, n, k);

            // 按照价格升序，券数升序
            Arrays.sort(result, (a, b) -> {
                if (a[0] != b[0]){
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            });
            System.out.println(result[0][0] + " " + result[0][1]);
        }
    }

    // 先打折后无门槛
    private static int[] mode_d(int price, int n, int k) {
        int count = 0;
        price *= 0.92;
        count++;
        for (int i = 0; i < k; i++) {
            price -= 5;
            count++;
            if (price < 0){
                break;
            }
        }
        return new int[]{price, count};
    }

    // 先满减后无门槛
    private static int[] mode_c(int price, int m, int k) {
        int count = 0;
        while (m > 0){
            if (price < 100){
                break;
            }
            price -= (price/100 * 10);
            count++;
            m--;
        }

        for (int i = 0; i < k; i++) {
            price -= 5;
            count++;
            if (price < 0){
                break;
            }
        }
        return new int[]{price, count};
    }

    /*
    * 先打折后满减
    * */
    private static int[] mode_b(int price, int m, int n) {
        int count = 0;
        price *= 0.92;
        count++;
        while (m > 0){
            if (price < 100){
                break;
            }
            price -= (price/100 * 10);
            count++;
            m--;
        }

        return new int[]{price, count};
    }

    /*
    * 先满减再打折
    * */
    private static int[] mode_a(int price, int m, int n) {
        int count = 0;
        while ( m > 0){
            if (price < 100){
                break;
            }
            price -= (price / 100 * 10);
            count++;
            m--;
        }
        price *= 0.92;
        count++;
        return new int[]{price, count};
    }






}
