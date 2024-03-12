package huawei;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class 求最大数字 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String number = scanner.nextLine();
            String res = solution(number);
            System.out.println(res);
        }
    }

    private static String solution(String number) {
        HashMap<Character, Integer> cCount = new HashMap<>();
        LinkedList<Character> resLink = new LinkedList<>();
        for (char c: number.toCharArray()) {
            cCount.put(c, cCount.getOrDefault(c, 0) +1);
            resLink.add(c);
        }

        for (Map.Entry<Character, Integer> entry: cCount.entrySet()) {
            Character c= entry.getKey();
            Integer count = entry.getValue();
            for (int i = 0; i < resLink.size() && count > 2; i++) {
                if (resLink.get(i) == c) {
                    if (i == resLink.size() - 1) {
                        resLink.removeLast();
                        count--;
                    } else if(resLink.get(i + 1) > c){
                    resLink.remove(i);
                    i--;
                    count--;
                }
            }
        }
        }
    StringBuilder builder = new StringBuilder();
        for (Character c: resLink
             ) {
            builder.append(c);
        }

        return builder.toString();
    }


}
