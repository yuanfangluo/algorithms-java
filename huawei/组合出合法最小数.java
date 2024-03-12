package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 组合出合法最小数 {
   static List<Integer> list = new ArrayList<>(); // 非0开头的数字
   static List<Integer> listZero = new ArrayList<>(); // 0开头的数字

    /*
    * 20 1
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String[] strs = scanner.nextLine().split(" ");
            combines(strs, 0, strs.length);

            if (list.size() == 0){ // 说明都是以0开头的
                Collections.sort(listZero);
                System.out.println(listZero.get(0));
            } else {
                Collections.sort(list);
                System.out.println(list.get(0));
            }
        }
    }

    static void swap(String[] strings, int a, int b) {
        String tmp = strings[a];
        strings[a] = strings[b];
        strings[b] = tmp;
    }

    /**
     * 经典全排列回溯（需要强行背诵）
     * @param strs 需要排练的数组
     * @param index 处理的索引
     * @param end 数组结尾位置（不包含）
     */
    private static void combines(String[] strs, int index, int end) {
        if (index == end){ // 所有的数据都遍历完成
            String res = "";
            for (int i = 0; i < strs.length; i++) {
                res += strs[i];
            }

            if (res.startsWith("0")){ // 以0开头的需要分开放
                listZero.add(Integer.valueOf(res));
            } else {
                list.add(Integer.valueOf(res));
            }
        } else {
            for (int i = index; i < strs.length; i++) {
                swap(strs, i, index);
                combines(strs, index + 1, end);
                swap(strs, i, index);
            }

        }
    }
}
