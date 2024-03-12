package huawei;

import java.util.Scanner;

public class 最优资源分配 {
    /*
    *
    * 8
    * 2
    * ACABA
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt(); // 每块芯片的容量
            int n = scanner.nextInt(); // 每块板卡包含的芯片数量
            scanner.nextLine();
            String config = scanner.nextLine();
            solution(m, n, config);
        }
    }

    private static void solution(int m, int n, String config) {
        int[] used = {1, 2, 8};
        int[] cores = new int[n];

        for (int i = 0; i < n; i++) {
            cores[i] = m;
        }

        char[] chars = config.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            // 当前配置消耗的芯片容量
            int cur = used[c - 'A'];

            for (int i = 0; i < cores.length; i++) {
                int remaining = cores[i];
                if (remaining >= cur){
                    cores[i] = remaining - cur;
                    break;
                }
            }

            if (j == chars.length - 1){
                for (int core: cores) {
                    for (int i = 0; i < m - core; i++) {
                    System.out.print("1");
//                        builder.append("1");
                    }

                    for (int i = 0; i < core; i++) {
                    System.out.print("0");
//                        builder.append("0");
                    }
                    System.out.println();
                }
            }
        }
    }


}
