package huawei;

import java.util.Scanner;

public class 最多提取子串数目 {
    /*
    *
    * badc
    * bac
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int res = solution(a, b);
            System.out.println(res);
        }
    }

    private static int solution(String a, String b) {
        int count = 0;
        while (true){
            char[] chars = b.toCharArray();
            int last = 0;
            for (char c: chars) {
                int index = a.indexOf(c, last);
                last = index;
                if (index != -1){
                    a = a.replaceFirst(c + "", "_");
                } else {
                    return count;
                }
            }
            count++;
        }
    }


        private static int solution1(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int[] indexes = new int[b.length()];

        int count = 0;
        boolean found = true;
        while (found) {
            for (int i = 0; i < charsB.length; i++) {
                int pos = a.indexOf(charsB[i], i == 0 ? 0 : indexes[i - 1]);
                if (pos != -1){
                    indexes[i] = pos;
                } else {
                    found = false;
                    break;
                }
            }

            if (found) {
                for (int index: indexes) {
                    charsA[index] = '-';
                    a = new String(charsA);
                }
                count++;
            }
        }
        return count;
    }
}
