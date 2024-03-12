package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class 寻找相似单词 {
    /*
    *
    * 4
    * abc
    * dasd
    * tad
    * bca
    * abc
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt(); // 单词个数
            String[] words = new String[n]; // 单词数组
            for (int i = 0; i < n; i++) {
                words[i] = scanner.next();
            }
            String target = scanner.next();// 目标单词
            System.out.println(solution(words, target));
        }
    }

    private static String solution(String[] words, String target) {
        String sorted_target = sort(target);
        ArrayList<String> ans = new ArrayList<>();
        for (String word: words) {
            String sorted_word = sort(word);
            if (sorted_target.equals(sorted_word)){
                ans.add(word);
            }
        }

        if (ans.size() > 0){
            // 数组元素排序
            ans.sort(String::compareTo);
            StringJoiner sj = new StringJoiner(" ");
            for (String an:ans
                 ) {
                sj.add(an);
            }
            return sj.toString();

        } else {
            return "null";
        }
    }

    private static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
