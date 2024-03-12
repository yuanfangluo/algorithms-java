package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 去除多余空格 {
    /*
    *
    * Life is painting a  picture, not doing 'a  sum'.
    * 8 15,20 26,43 45
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            String pos = scanner.nextLine();
            solution(line, pos);
        }
    }

    private static void solution(String line, String pos) {
        String[] split = pos.split(",");
        String[] keys = new String[split.length];

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] indexes = s.split(" ");
            int l = Integer.parseInt(indexes[0]);
            int r = Integer.parseInt(indexes[1]);
            keys[i] = line.substring(l, r + 1);
        }

//        System.out.println(Arrays.toString(keys));
        StringBuilder builder = new StringBuilder();
        char[] chars = line.toCharArray();
        boolean inner = false;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '\'') {
                inner = !inner;
            }
            if (inner){
                builder.append(c);
                continue;
            }
            if (c == ' ' && chars[i - 1] == ' ') {
                continue;
            }
            builder.append(c);
        }
        System.out.println(builder);

        for (String key: keys
             ) {
            int l = builder.indexOf(key);
            int r = l + key.length() - 1;
            System.out.println(Arrays.toString(new int[]{l, r}));
        }
    }


}
