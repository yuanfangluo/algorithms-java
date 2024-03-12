package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class 机房布局 {
    /*
    * MIIM
    * */
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            String line = scanner.next();
            System.out.println(solution(line));
        }
    }

    private static int solution(String line) {
        int n = line.length();
        LinkedList<Integer[]> stack = new LinkedList<>();
        boolean stick = false;

        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == 'M') {
                boolean left = i - 1 < 0 || line.charAt(i -1) == 'M';
                boolean right = i + 1 >= n || line.charAt(i + 1) == 'M';

                if (left && right) return -1;

                Integer[] range = {Math.max(0, i -1), Math.min(n - 1, i + 1)};

                if (stack.size() > 0 && !stick) {
                    int e1 = stack.getLast()[1];
                    int s2 = range[0];

                    if (e1 == s2) {
                        stack.removeLast();
                        stick = true;
                    }
                } else {
                    stick = false;
                }
                stack.addLast(range);
            }

        }
        return stack.size();
    }


}
