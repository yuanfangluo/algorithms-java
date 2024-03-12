package huawei;

import java.util.HashMap;
import java.util.Scanner;

public class 知识图谱新词挖掘 {
    /*
    *
    * qweebaewqd
    * qwe
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String content = scanner.next();
            String word = scanner.next();
            System.out.println(solution(content, word));
        }
    }

    private static int solution(String content, String word) {
        if (content.length() < word.length()) {
            return 0;
        }

        int res = 0;

        int total = word.length();

        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < word.length(); i++) {
            Character c = content.charAt(i);
            if (count.containsKey(c)){
                if (count.get(c) > 0) {
                    total--;
                }
                count.put(c, count.get(c) - 1);
            }
        }

        if (total == 0) res++;

        int maxI = content.length() - word.length();

        for (int i = 1; i <= maxI ; i++) {
            Character remove_c = content.charAt(i - 1);
            Character add_c = content.charAt(i + word.length() - 1);
            if (count.containsKey(remove_c)){
                if (count.get(remove_c) >= 0) {
                    total++;
                }
                count.put(remove_c, count.get(remove_c) + 1);
            }

            if (count.containsKey(add_c)){
                if (count.get(add_c) > 0){
                    total--;
                }
                count.put(add_c, count.get(add_c) -1);
            }
            if (total == 0){
                res++;
            }
        }
        return res;
    }


}
