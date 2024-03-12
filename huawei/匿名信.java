package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 匿名信 {
    /*
    * ab ef
    * aef
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String newspaper = scanner.nextLine();
            String anonymousLetter = scanner.nextLine();
            boolean res = solution(newspaper, anonymousLetter);
            System.out.println(res);
        }
    }

    private static boolean solution(String newspaper, String anonymousLetter) {
        List<String> newspaperList = sort(newspaper);
        List<String> anonymousLetterList = sort(anonymousLetter);

        for (String str: anonymousLetterList
             ) {
            if (!newspaperList.contains(str)){
                return false;
            }
        }
        return true;
    }

    private static List<String> sort(String newspaper) {
        List<String> strings = new ArrayList<>();
        String[] split = newspaper.split(" ");
        for (String str:
             split) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            strings.add(new String(chars));
        }
        return strings;
    }


}
