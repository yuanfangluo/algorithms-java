package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 最大数字 {

    /*
    *
    * 34533
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String str = scanner.nextLine();
            System.out.println(solution(str));
        }
    }

    private static String solution(String str) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        // 统计输入字符串中各字符串出现的次数
        for (int i = 0; i < str.length(); i++) {
            Character k = str.charAt(i);
            countMap.put(k, countMap.getOrDefault(k, 0) + 1);
        }

        // res 记录题解
        ArrayList<Character> res = new ArrayList<>();

        // has用于记录res中的字符已经有了几个
        HashMap<Character, Integer> has = new HashMap<>();

        // 遍历输入字符串的各个字符
        for (int i = 0; i < str.length(); i++) {
            Character cur = str.charAt(i);

            if (countMap.get(cur) <= 2){
                res.add(cur);
                continue;
            }

            // 次数超过2，考虑删除
            int j = i + 1;

            if (j < str.length()){
                char next = str.charAt(j);
                if (!has.containsKey(cur)) has.put(cur, 0);

                int curHas = has.get(cur);

                if (cur > next && curHas < 2){ // 当前字符大于下一个字符，并且保留字符的个数小于2个，可以保留
                    res.add(cur);
                    has.put(cur, ++curHas);
                } else {
                    // 否则不保留
                    int curCount = countMap.get(cur);
                    countMap.put(cur, --curCount);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Character c: res
             ) {
            builder.append(c);
        }
        return builder.toString();
    }
}
