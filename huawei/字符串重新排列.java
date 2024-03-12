package huawei;

import java.util.*;

public class 字符串重新排列 {
    /*
    * My sister is in the house not in the yard
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            // 第一步，单词内部调整
            ArrayList<String> str_list = new ArrayList<>();
            for (String s: strs
                 ) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                str_list.add(new String(chars));
            }

            // 第二步：单词间调整
            // 先统计每个单词出现的次数
            HashMap<String, Integer> str_count = new HashMap<>();
            for (String s: str_list
                 ) {
                str_count.put(s, str_count.getOrDefault(s, 0) + 1);
            }

            // 按次数排列
            List<Map.Entry<String, Integer>> str_count_list = new ArrayList<>(str_count.entrySet());
            // 通过比较器实现比较排序
            str_count_list.sort((entry1, entry2) -> {
                if (entry1.getValue() != entry2.getValue()){
                    //  出现次数降序
                    return entry2.getValue() - entry1.getValue();
                } else {
                    if (entry1.getKey().length() != entry2.getKey().length()){
                        // 单词长度升序
                        return entry1.getKey().length() - entry2.getKey().length();
                    } else {
                        // 字典升序
                        return entry1.getKey().compareTo(entry2.getKey());
                    }

                }


            });

            StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, Integer> entry: str_count_list
                 ) {
                for (int i = 0; i < entry.getValue(); i++) {
                    builder.append(entry.getKey()).append(" ");
                }
            }

            System.out.println(builder.toString());
        }

    }
}
