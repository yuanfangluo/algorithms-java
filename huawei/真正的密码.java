package huawei;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class 真正的密码 {

    /*
     * h he hel hell hello o ok n ni nin ninj ninja
     *
     * */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            String[] split = scanner.nextLine().split(" ");

            // 将所有字符串放入HashSet
            HashSet<String> word_set = new HashSet<>();
            Collections.addAll(word_set, split);

            // 真正的密码
            String true_pass_word = "";

            // 按顺序检查每一个词
            for (String str: split
                 ) {
                // 条件1：检查这个词所有以索引0开头的子串在数组中是否都有
                boolean flag = true;
                for (int i = 1; i < str.length(); i++) {
                    // 以索引0开头的子串
                    String sub_str = str.substring(0, i);
                    if (!word_set.contains(sub_str)){
                        flag = false;
                        break;
                    }
                }

                if (flag){
                    // 条件2：比较密码长度
                    if (str.length() > true_pass_word.length()){
                        true_pass_word = str;
                    }

                    // 条件3： 比较密码字典顺序
                    if (str.length() == true_pass_word.length() && str.compareTo(true_pass_word) > 0){
                        true_pass_word = str;
                    }
                }

            }
            System.out.println(true_pass_word);
        }
    }


}
