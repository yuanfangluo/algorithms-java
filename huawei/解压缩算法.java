package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class 解压缩算法 {
    /*
    * {A3B1{C}3}3
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String str = scanner.next();
            System.out.println(solution(str));
        }
    }

    private static String solution(String str) {
        LinkedList<String> stack = new LinkedList<>();
        // idxs, 记录左括号 { 出现的位置
        LinkedList<Integer> idxs = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ( c >= '0' && c <= '9'){ // 遇到数字
                int repeat = Integer.parseInt(c + "");
                if ("}".equals(stack.getLast())){ // 栈顶是 }
                    int left = idxs.removeLast(); // 左括号的位置
                    stack.remove(left); // 去掉 {
                    stack.removeLast(); // 去掉 }
                    updateStack(stack, left, repeat); // 将{}中间部分重复repeat次后重新入栈
                } else { // 如果此时栈顶不是 } ,只需将栈顶元素重复repeat次
                    updateStack(stack, stack.size() - 1, repeat);
                }
                // 数字不入栈
                continue;
            }
            // 记录 { 出现的位置
            if (c == '{'){
                idxs.addLast(stack.size());
            }

            // 数字外的字符都压入栈中
            stack.addLast(c + "");
        }
        StringBuilder builder = new StringBuilder();
        for (String c: stack
             ) {
            builder.append(c);
        }
        return builder.toString();
    }

    private static void updateStack(LinkedList<String> stack, int left, int repeat) {
        // 需要弹出栈的个数
        int count = stack.size() - left;
        String[] frag = new String[count];

        while (count > 0){
            count--;
            frag[count] = stack.removeLast();
        }

        // 重复的是弹栈内容的整体
        StringBuilder builder = new StringBuilder();
        for (String s: frag
             ) {
            builder.append(s);
        }

        // 将弹栈内容重复repeat次入栈
        String fragment = builder.toString();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            ans.append(fragment);
        }
        stack.addLast(ans.toString());
    }


}
