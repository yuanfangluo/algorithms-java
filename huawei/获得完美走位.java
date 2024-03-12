package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 获得完美走位 {
    /*
    * ASDW
    * AASW
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String ops = scanner.nextLine();
            solutions(ops);
        }
    }

    private static void solutions(String ops) {
        char[] chars = ops.toCharArray();
        int len = chars.length;
        int count = len / 4;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 这个代表
        map.replaceAll((k, v) -> v - count);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            char c1 = chars[i];
            int res = 0;
            Map<Character, Integer> changed = new HashMap<>(map);
            if (changed.get(c1) > 0) {
                for (int j = i; j < len; j++) {
                    char c2 = ops.charAt(j);
                    changed.put(c2, changed.get(c2) - 1);
                    res++;
                    if (check(changed)){
                        break;
                    }
                }
            }

            if (check(changed)){
                min = Math.min(min, res);
            }
        }

        System.out.println(min);
    }

    public static boolean check(Map<Character, Integer> map) {
        for (Integer i: map.values()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
