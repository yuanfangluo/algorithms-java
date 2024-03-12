package huawei;

import java.util.HashMap;
import java.util.Scanner;

public class 找出通过车辆最多颜色 {
    /*
    * 0 1 2 1
    * 3
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            int width = scanner.nextInt();
            int res = solution(line, width);
            System.out.println(res);
        }
    }

    private static int solution(String line, int w) {
        String[] split = line.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            String cur = split[i];
            // 时间超过窗口长度，则移除窗口最早的数据
            if (i > w) {
                String out = split[i -w];
                map.put(out, map.getOrDefault(out, 1) - 1);
            }

            // 更新车辆颜色的计数
            int count = map.getOrDefault(cur, 0) + 1;
            map.put(cur, count);

            // 更新出现最多颜色的数量
            max = Math.max(max, count);
        }

        return max;
    }


}
