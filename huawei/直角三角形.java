package huawei;

import java.util.*;

public class 直角三角形 {
    /*
    * 1
    * 7 3 4 5 6 5 12 13
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int t = scanner.nextInt();
            int[][] cases = new int[t][];

            for (int i = 0; i < t; i++) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                for (int j = 0; j < n; j++) {
                    arr[j] = scanner.nextInt();
                }
                cases[i] = arr;
            }

            solution(cases);
        }
    }

    private static void solution(int[][] cases) {
        for (int[] arr: cases
             ) {
            // 对每组测试线段升序排序
            Arrays.sort(arr);

            HashMap<String, Integer> count = new HashMap<>();
            count.put("val", 0);
            dfs(arr, 0, new LinkedList<>(), count);
            System.out.println(count.get("val"));
        }
    }

    // n个数中选三个
    private static void dfs(
            int[] arr,
            int index,
            LinkedList<Integer> path,
            HashMap<String, Integer> count) {
        if (path.size() == 3){
            if (isRight(path)){
                count.put("val", count.get("val") + 1);
                return;
            }
        }

        for (int i = index; i < arr.length; i++) {
            // arr已经三升序的了，因此相同的数字肯定三相邻的，可以去重
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            path.add(arr[i]);
            dfs(arr, i + 1, path, count);
            path.removeLast();
        }
    }

    private static boolean isRight(LinkedList<Integer> path) {
        int x = path.get(0);
        int y = path.get(1);
        int z = path.get(2);
        return x * x + y * y == z * z;

    }


}
