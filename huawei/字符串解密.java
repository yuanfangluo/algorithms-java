package huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 字符串解密 {
    /*
    *
    * 123admyffc79pt
    * ssyy
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String str1 = scanner.next();
            String str2 = scanner.next();

            System.out.println(solution(str1, str2));
        }
    }

    private static String solution(String str1, String str2) {
        String reg = "[0-9a-f]+"; // 加扰字符串
        String[] valids = str1.split(reg);

        int count = getDistinctCount(str2);
        String[] res = Arrays.stream(valids)
                .filter(valid -> !"".equals(valid) && getDistinctCount(valid) <= count)
                .toArray(String[]::new);

        if (res.length == 0) return "Not Found";

        return Arrays.stream(res).sorted((a, b) -> {
            int c1 = getDistinctCount(a);
            int c2 = getDistinctCount(b);
            return c1 != c2 ? c2 - c1 : b.compareTo(a);
        }).toArray(String[]::new)[0];
    }

    // 获取字符串的不重复字符个数
    private static int getDistinctCount(String str) {
        HashSet<Character> set = new HashSet<>();
        for (char c: str.toCharArray()
             ) {
            set.add(c);
        }
        return set.size();
    }
}
