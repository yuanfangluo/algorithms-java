package huawei;

import java.util.Scanner;

public class 数组的中心位置 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        int lPro = 1, rPro = 1;
        String[] split = line.split(" ");
        int[] ints = new int[split.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
            // 累积
            rPro *= ints[i];
        }

        for (int i = 0; i < ints.length; i++) {
            rPro /= ints[i];
            if (lPro == rPro) {
                return i;
            }
            lPro *= ints[i];
        }
        return -1;
    }


}
