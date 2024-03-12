package huawei;

import java.util.Scanner;

public class 统一限载货物数最小值 {
    /*
    * 4
    * 3 2 6 3
    * 0 1 1 0
    * 2
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int num = scanner.nextInt();
            int[] goods = new int[num];
            for (int i = 0; i < num; i++) {
                goods[i] = scanner.nextInt();
            }

            int[] types = new int[num];

            for (int i = 0; i < num; i++) {
                types[i] = scanner.nextInt();
            }

            int k = scanner.nextInt();

            // 由于一家的商品不能分拆，一辆车的载重也需要 >= 这个数
            int max_weight = 0;

            int dry_sum = 0;
            int wet_sum = 0;

            for (int i = 0; i < num; i++) {
                if (types[i] == 0){ // 干货
                    dry_sum += goods[i];
                } else {
                    wet_sum += goods[i];
                }
                max_weight = Math.max(max_weight, goods[i]);
            }

            System.out.println(Math.max(max_weight, Math.max(dry_sum, wet_sum) / k));
        }
    }
}
