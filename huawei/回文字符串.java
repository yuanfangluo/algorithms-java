package huawei;

import java.util.*;

public class 回文字符串 {
    /*
    * abczcccddzz
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String inputStr = scanner.nextLine();
            String res = solution(inputStr);
            System.out.println(res);
        }
    }

    private static String solution(String inputStr) {
        List<Character> chList = new ArrayList<>();
        for (char c:
             inputStr.toCharArray()) {
            chList.add(c);
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c:
             chList) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // 只含有一种字符吗，这种字符的个数不限
        if (countMap.size() <= 1){
            return inputStr;
        }

        Map<Character, Integer> validMap = new HashMap<>();

        for (Map.Entry<Character, Integer> entry: countMap.entrySet()
             ) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (count != 1){
                if (count %2 == 0){ // 偶数
                    validMap.put(c, count);
                    countMap.put(c, 0);
                } else {
                    validMap.put(c, count - 1);
                    countMap.put(c, 1);
                }
            }
        }

        List<Map.Entry<Character, Integer>> sortedCountList = new ArrayList<>(countMap.entrySet());
        Collections.sort(sortedCountList, Map.Entry.comparingByKey());

        List<Map.Entry<Character, Integer>> sortedValidList = new ArrayList<>(validMap.entrySet());
        Collections.sort(sortedValidList, Map.Entry.comparingByKey());

        String ans = "";
        for (Map.Entry<Character, Integer> entry:
             sortedValidList) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count / 2; i++) {
                ans += c;
            }
        }

        boolean singleFlag = false;

        for (Map.Entry<Character, Integer> entry:
             sortedCountList) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (count == 1){
                ans += c;
                singleFlag = true;
                break;
            }
        }

        if (singleFlag){
            ans += new StringBuilder(ans).reverse().substring(1);
        } else {
            ans += new StringBuilder(ans).reverse().toString();

        }
        return ans;
    }
}
