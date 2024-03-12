package huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 二元组个数 {
    /*
    * 4
    * 1 2 3 4
    * 1
    * 1
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt();
            int[] arr1 = new int[m];
            for (int i = 0; i < m; i++) {
                arr1[i] = scanner.nextInt();
            }

            int n = scanner.nextInt();
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr2[i] = scanner.nextInt();
            }

            long res = solution(arr1, arr2);
            System.out.println(res);
        }
    }

    private static long solution(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> m_info = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];
            if (m_info.containsKey(num)){
                m_info.put(num, m_info.get(num) + 1);
            } else {
                m_info.put(num, 1);
            }
        }

        HashMap<Integer, Integer> n_info = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            if (n_info.containsKey(num)){
                n_info.put(num, n_info.get(num) + 1);
            } else {
                n_info.put(num, 1);
            }
        }

        // 算对数
        long result = 0;
        for (Map.Entry<Integer,Integer> x:
             m_info.entrySet()) {
            if (n_info.containsKey(x.getKey())){
                result += x.getValue() * n_info.get(x.getKey());
            }
        }

        return result;
    }
}
