package huawei;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class 人数最多的站点 {
    /*
    *
    * 3
    * 1 3
    * 2 4
    * 1 4
    * */
    public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)){
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int[] pair = {Math.min(start, end), Math.max(start, end)};
            nums[i] = pair;
        }

        // 创建人数的数据结构

        HashMap<Integer, Integer> site_map = new HashMap<>();

        for (int[] pair: nums
             ) {
            for (int i = pair[0]; i <= pair[1]; i++) {
                site_map.put(i, site_map.getOrDefault(i, 0) + 1);
            }
        }

        LinkedList<Map.Entry<Integer, Integer>> sites = new LinkedList<>(site_map.entrySet());

        sites.sort((e1, e2)-> e2.getValue() - e1.getValue());

        System.out.println(sites.get(0).getKey());
    }
    }

}
