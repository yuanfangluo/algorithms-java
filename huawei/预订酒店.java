package huawei;

import java.util.*;

public class 预订酒店 {
    /*
    * 筛选k个最接近x元的酒店
    * n k x
    * 10 5 6
    * 1 2 3 4 5 6 7 8 9 10
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }

            solution(prices, n, k, x);
        }
    }

    private static void solution(int[] prices, int n, int k, int x) {
        Arrays.sort(prices);
        int[][] price_rating = new int[n][2];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            price_rating[i][0] = price;
            price_rating[i][1] = Math.abs(price - x);
        }

        List<int[]> sorted = Arrays.stream(price_rating).sorted(Comparator.comparingInt(h -> h[1])).toList();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(sorted.get(i)[0]);
        }

        res.sort(Integer::compareTo);

//        System.out.println(Arrays.toString(res.toArray()));

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1){
                System.out.println(" ");
            }
        }


    }
}
