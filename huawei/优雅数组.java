package huawei;

import java.util.HashMap;
import java.util.Scanner;

public class 优雅数组 {
    /*
    * 7 3
    * 1 2 3 1 2 3 1
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt(); // 数组的长度
            int k = scanner.nextInt(); // 优雅阈值
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(solution(arr, n, k));
        }
    }

    private static int solution(int[] arr, int n, int k) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int j = i; j < n; j++) {
                Integer key = arr[j];
                count.put(key, count.getOrDefault(key, 0) + 1);
                if (count.get(key) >= k){
                    res += n - j;
                    break;
                }
            }
        }
        return res;
    }

}
