package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 冗余覆盖 {
    /*
    * ab
    * aabcd
    * 1
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            int k = scanner.nextInt();
            System.out.println(solution(s1, s2, k));

        }
    }

    private static int solution(String s1, String s2, int k) {
        int len = s1.length() + k;
        if (s2.length() < len) {
            return -1;
        }

        Map<Character, Integer> s1wc = getWC(s1);

        for (int i = 0; i < s2.length(); i++) {
            String subStr = s2.substring(i, i + len);
            Map<Character, Integer> sub_wc = getWC(subStr);
            boolean flag = true;
            for (Character key: s1wc.keySet()
                 ) {
                if (s1wc.get(key) > sub_wc.getOrDefault(key, 0)){
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i;
            }
        }

        return -1;

    }

    private static Map<Character, Integer> getWC(String s1) {
        Map<Character, Integer> wc = new HashMap<>();
        for (char c: s1.toCharArray()
             ) {
            wc.put(c, wc.getOrDefault(c, 0) + 1);
        }
        return wc;
    }


}
