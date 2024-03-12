package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 最差产品奖 {
    /*
    * 相邻的最差的：
    * 3 // 评分区间长度
    * 12,3,8,6,5
    * 评分区间长度的差的：
    * (12, 3， 8) -> 3
    * (3, 8， 6) -> 3
    * (8, 6， 5) -> 5
    * 结果：3， 3， 5
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt();
            scanner.nextLine();
            String pdc= scanner.nextLine();
            String res = solution(m, pdc);
            System.out.println(res);
        }
    }

    private static String solution(int m, String pdc) {
        String[] split = pdc.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length - (m - 1); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < i + m; j++) {
                min = Math.min(min, Integer.parseInt(split[j]));
            }
            list.add(min);
        }
        return list.toString();
    }
}
