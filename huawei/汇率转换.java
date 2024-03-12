package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 汇率转换 {
    /*
    * 1
    * 100CNY
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextLine();
            }
            int res = solution(input);
            System.out.println(res);
        }
    }

    private static final Pattern pNum = Pattern.compile("[0-9]+");
    private static final Pattern pWord = Pattern.compile("([a-z]|[A-Z])+");

    private static int solution(String[] input) {
        Map<String, Double> exchange = new HashMap<>();
        exchange.put("CNY", 0.01);
        exchange.put("fen", 1.);
        exchange.put("JPY", .1825);
        exchange.put("sen", 18.25);
        exchange.put("HKD", 0.0123);
        exchange.put("cents", 1.23);
        exchange.put("EUR", 0.0014);
        exchange.put("eurocents", 0.14);
        exchange.put("GBP", 0.0012);
        exchange.put("pence", 0.12);

        double res = 0;
        for (String s: input) {
            String str = s;
            String num = "";
            String word = "";
            while (str.length() > 0) {
                Matcher mNum = pNum.matcher(str);
                if (mNum.find()) {
                    num = mNum.group();
                    str = str.substring(num.length());
                }
                Matcher mWord = pWord.matcher(str);
                if (mWord.find()) {
                    word = mWord.group();
                    str = str.substring(word.length());
                }
                res += Double.parseDouble(num) / exchange.get(word);
            }
        }
        return (int) res;
    }
}
