package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Linux发行版的数量 {
    static int n;
    static int[][] ints;
    static Set<Integer> set;
    /*
    * 4 // 发行版的数量
    * 1 1 0 0
    * 1 1 1 0
    * 0 1 1 0
    * 0 0 0 1
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            n = scanner.nextInt();
            ints = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ints[i][j] = scanner.nextInt();
                }
            }

            Set<Integer> tmp = new HashSet<>(); // 已经关联的Linux版本集合
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (!tmp.contains(i)){ // 已经关联过的不需要处理
                    set = new HashSet<>();
                    handle(i);
                    max = Math.max(max, set.size()); // set的大小代表发行版的数量
                    tmp.addAll(set);

                }
            }
            System.out.println(max);

        }
    }

    /**
     * 找出所有与linux相关的版本
     * @param linux
     */
    private static void handle(int linux) {
        for (int i = 0; i < n; i++) {
            if (!set.contains(i) && ints[linux][i] == 1) { // 已经关联的版本无需处理
                set.add(i); // 添加到已关联的版本
                handle(i);
            }
        }
    }


}
