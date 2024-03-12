package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 区块链文件转储系统 {
    /*
    * 1000
    * 100 300 500 400 400 150 100
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int m = Integer.parseInt(scanner.nextLine());
            Integer[] f = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

//            String[] strs = scanner.nextLine().split(" ");
//            int[] fs = new int[strs.length];
//            for (int i = 0; i < strs.length; i++) {
//                fs[i] = Integer.parseInt(strs[i]);
//            }

            System.out.println(solution(m, f));
        }
    }

    private static int solution(int m, Integer[] f) {
        int l = 0; // 左边界
        int r = 0; // 右边界
        int sum = 0; // 连续文件大小之和
        int max = 0; // 最大连续和

        int n = f.length;
        while (r < n){
            int newSum = sum + f[r];
            if (newSum > m){
                sum -= f[l++];
            } else if (newSum < m) {
                sum += f[r++];
                max = Math.max(sum,max);
            } else {
                return m;
            }
        }

        return max;
    }

}
