package huawei;

import java.util.Map;
import java.util.Scanner;

public class 新员工座位安排系统 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            int max = solution(line);
            System.out.println(max);
        }
    }

    private static int solution(String line) {
        String sites = line.replaceAll(" ", "");
        char[] chars = sites.toCharArray();
        int max = 0;
        for (int i = 0; i <sites.length(); i++) {
            int index = sites.indexOf("0", i);
            if (index == -1) {
                break;
            }
            i = index;
            int tmp = 0;
            while (index > 0 && chars[index - 1] == '1'){
                index--;
                tmp++;
            }
            index = i;
            while (index < sites.length() - 1 && chars[index + 1] == '1') {
                index++;
                tmp++;
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

}
