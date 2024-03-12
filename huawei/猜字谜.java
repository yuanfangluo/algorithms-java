package huawei;

import java.util.*;

public class 猜字谜 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String aim = scanner.nextLine();
            String check = scanner.nextLine();
            solution(aim, check);
        }
    }

    private static void solution(String aim, String check) {
        String[] split = check.split(",");
        String[] seq1 = convert(aim.split(","));
        String[] seq2 = convert(check.split(","));

        List<String> res = new ArrayList<>();
        for (String s1:
             seq1) {
            for (int i = 0; i <seq2.length ; i++) {
                if (s1.equals(seq2[i]) && !res.contains(split[i])){
                    res.add(split[i]);
                }
            }
        }

        if (res.size() == 0){
            System.out.println("not found");
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i != res.size() -1){
                    System.out.print(",");
                }
            }
        }
    }

    private static String[] convert(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            TreeSet<Character> characters = new TreeSet<>();
            String str = strs[i];
            // 去除重复字符
            for (char c:
                 str.toLowerCase().toCharArray()) {
                characters.add(c);
            }

            // set 转为 array
            Character[] array = characters.toArray(new Character[0]);
            System.out.println(Arrays.toString(array));;
            char[] chars = new char[array.length];
            for (int j = 0; j < array.length; j++) {
                chars[j] = array[j];
            }
            strs[i] = new String(chars);
        }
        return strs;
    }

}
