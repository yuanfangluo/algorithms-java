package huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class 密室逃生 {
    /*
    * abc
    * s,sdf134 A2c4b
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String key = scanner.nextLine();
            String boxes = scanner.nextLine();
            int res = solution(key, boxes);
            System.out.println(res);
        }
    }

    private static int solution(String key, String boxes) {
        String[] split = boxes.substring(2).split(" ");
        for (int i = 0; i < split.length; i++) {
            String lower = split[i].toLowerCase();
            // 会按照从小到大排序的
            TreeSet<Character> chars = new TreeSet<>();
            for (char c: lower.toCharArray()
                 ) {
                if (c >= 'a' && c <= 'z'){
                    chars.add(c);
                }
            }

            if (chars.size() == key.length()){
                StringBuilder builder = new StringBuilder();
                for (Character c: chars
                     ) {
                    builder.append(c);
                }

                if (builder.toString().equals(key)){
                    return i + 1;
                }
            }
        }

        return -1;


    }


}
