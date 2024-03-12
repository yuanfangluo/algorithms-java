package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 云短信平台优惠活动 {
    /*
    * 6
    * 10 20 30 40 60
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int amount = scanner.nextInt();
            scanner.nextLine();
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int[] counts = new int[split.length];
            for (int i = 0; i < counts.length; i++) {
                counts[i] = Integer.parseInt(split[i]);
            }

            int max = solution(amount, counts);
            System.out.println(max);
        }
    }

    private static int solution(int amount, int[] counts) {
        int max = 0;
        List<Bundle> bundles = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            int price = i + 1;
            int count = counts[i];
            bundles.add(new Bundle(price, count));
        }

        bundles.sort((b1, b2) -> Double.compare(b2.rating, b1.rating));

        for (int i = 0; amount > 0 ; i++) {
            Bundle bundle = bundles.get(i);
            if (bundle.price <= amount){
                max += bundle.count;
                amount -= bundle.price;
            }

            if (i == bundles.size() - 1){
                i = 0;
            }
        }

        return max;
    }

//    短信包
    static class Bundle {
        int price;
        int count;
        double rating; // 单条短信的价格

    public Bundle(int price, int count) {
        this.price = price;
        this.count = count;
        this.rating = count * 1.0 / price;
    }
}

}
