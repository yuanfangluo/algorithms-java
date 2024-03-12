package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 取出尽量少的球 {
    /*
    * 如果所有桶的小球总和小于SUM，无需设置最大容量，返回[]
    * 如果大于SUM，需要设置最大容量，返回需要每个小桶需要拿出的小球数组
    * 14 7
    * 2 3 2 5 5 1 4
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int sum = scanner.nextInt();
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(solution(sum, arr, n));
        }
    }

    private static String solution(int sum, int[] arr, int n) {
        int total = reduce(arr);
        if (total <= sum) return "[]";

        // maxCapacity 从最理想值开始取值，向下取值
        int maxCapacity = sum / n;

        int[] ans = null;

        while (true){
            // tmp保存每个桶移除的球的数量
            int[] tmp = new int[n];

            // 移除球的总数
            int remove = 0;
            for (int i = 0; i < arr.length; i++) {
                // r是每个桶需要移除的球的个数，如果桶内超过maxCapacity，需要移除，否则不需要
                int r = arr[i] > maxCapacity ? arr[i] - maxCapacity : 0;
                // 累加
                remove += r;
                tmp[i] = r;
            }

            int remain = total - remove;

            // 如果按照maxCapacity，发现剩余大于sum，说明不合要求，返回之前的结果
            if (remain > sum) break;

            ans = tmp;

            if (remain == sum) break;

            // 剩余数量小于sum，可以继续提高maxCapacity
            maxCapacity++;
        }

        return Arrays.toString(ans);
    }

//    前缀和
    private static int reduce(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
