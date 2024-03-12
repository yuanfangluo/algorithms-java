package huawei;

import javax.swing.*;
import java.util.*;

public class 整理扑克牌 {
    /*
    *
    * 1 3 3 3 2 1 5
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for (String s: split) {
            int number = Integer.parseInt(s);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        // (数值，个数)
        Comparator<Map.Entry<Integer, Integer>> entryComparator = (e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())){
                return e2.getValue() - e1.getValue();
            } else {
                return e2.getKey() - e1.getKey();
            }
        };

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        StringBuilder builder = new StringBuilder();
        while (list.size() > 0){
            list.sort(entryComparator);

            Map.Entry<Integer, Integer> first = list.get(0);

            // 炸弹
            if (first.getValue() >= 4){
                append(builder, first.getKey(), 4);
                if (first.getValue() - 4 == 0) { // 表示该数字只有4个
                    list.remove(0);
                } else {
                    first.setValue(first.getValue() - 4);
                }
                continue;
            }

            // 葫芦或三
            if (first.getValue() == 3 && list.size() > 1) { // 第一项是三张，不止一项
                Map.Entry<Integer, Integer> second = list.get(1);

                if (second.getValue() >= 2) {
                    // 添加葫芦
                    append(builder, first.getKey(), 3);
                    append(builder, second.getKey(), 2);

                    if (second.getValue() == 2) { // 刚好两张
                        list.remove(1);
                    } else {
                        second.setValue(second.getValue() - 2);
                    }

                    list.remove(0);
                    continue;
                } else { // 第二项只有一张
                    append(builder, first.getKey(), 3);
                    list.remove(0);
                    continue;
                }
            }

            // 其他
            int size = list.size();

            for (int i = 0; i < size; i++) {
                append(builder, list.get(0).getKey(), list.get(0).getValue());
                list.remove(0);
            }
        }
        System.out.println(builder.substring(0, builder.length() - 1));
    }

    private static void append(StringBuilder builder, int number, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(number).append(" ");
        }
    }
}
