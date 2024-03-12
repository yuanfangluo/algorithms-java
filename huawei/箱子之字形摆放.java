package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 箱子之字形摆放 {
    /*
    * ABCDEFG 3
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            String str = split[0];
            char[] chars = str.toCharArray();
            List<List<Character>> lists = new ArrayList<>();
            int n = Integer.parseInt(split[1]);
            for (int i = 0; i < n; i++) {
                lists.add(new ArrayList<>());
            }

            // 从0行开始
            int index = 0;
            // 如果向下，属于递增，也就是asc = true，
            // 向上，就是asc = false
            boolean asc = true;

            for (char c: chars
                 ) {
                if (index == -1){ // 需要向下
                    index = 0;
                    asc = true;
                }
                if (index == n){ // 需要向上
                    index = n - 1;
                    asc = false;
                }
                lists.get(index).add(c);

                if (asc){
                    index++;
                } else {
                    index--;
                }
            }

            // 输出结果
            for (List<Character> list: lists
                 ) {
                for (Character character: list
                     ) {
                    System.out.print(character);
                }
                System.out.println();
            }

        }
    }


}
