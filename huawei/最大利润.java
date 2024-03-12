package huawei;

import java.util.Scanner;

public class 最大利润 {
    /*
    * 3 // 商品的数量
    * 3 // 商品售货天数
    * 4 5 6 // 每件商品的最大持有数量
    * 1 2 3 // 第一件商品每天的价格
    * 4 3 2 // 第二件商品每天的价格
    * 1 5 3 // 第三件商品每天的价格
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int number = scanner.nextInt();
            int days = scanner.nextInt();
            int[] items = new int[number];
            for (int i = 0; i < number; i++) {
                items[i] = scanner.nextInt();
            }

            int[][] price = new int[number][days];
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < days; j++) {
                    price[i][j] = scanner.nextInt();
                }
            }

            solution(items, price);
        }
    }

    private static void solution(int[] items, int[][] price) {
        int sum = 0;
        for (int k = 0; k < price.length; k++) {
            int[] p = price[k];

            // 从后往前找到最大差
            int maxDiff = 0;

            for (int i = p.length - 1; i >= 0 ; i--) { // 倒数第一个开始
                for (int j = i - 1; j >= 0 ; j--) { // 倒数第二个开始
                    if (p[i] > p[j]){
                        maxDiff = Math.max(maxDiff, p[i] - p[j]);
                    }
                }
            }
            sum += items[k] * maxDiff;
        }
        System.out.println(sum);
    }
}
