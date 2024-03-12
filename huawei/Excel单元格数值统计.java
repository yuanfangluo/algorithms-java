package huawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Excel单元格数值统计 {

    /*
    *
    * 5 3
    * 10 12 =C5
    * 15 5 6
    * 7 8 =3+C2
    * 6 =B2-A1 =C2
    * 7 5 3
    * B2:C4
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine();
            String[][] sheet = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                sheet[i] = scanner.nextLine().split(" ");
            }
            String range = scanner.nextLine();
            int res = solution(rows, cols, sheet, range);
            System.out.println(res);
        }
    }
    private static final Pattern pattern1 = Pattern.compile("([A-Z])?([0-9]+)([+\\-])([A-Z])?([0-9]+)");
    private static final Pattern pattern2 = Pattern.compile("([A-Z])?([0-9]+)");
    private static final Pattern pattern3 = Pattern.compile("([A-Z])?([0-9]+)(:)([A-Z])?([0-9]+)");


    private static int solution(int rows, int cols, String[][] sheet, String range) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String value = sheet[r][c];
                if (value.startsWith("=")){
                    sheet[r][c] = evaluate(value, sheet);
                }
            }
        }

        Matcher matcher = pattern3.matcher(range);
        if (matcher.find()){
            int cs = matcher.group(1).charAt(0) - 'A';
            int rs = Integer.parseInt(matcher.group(2)) - 1;
            int ce = matcher.group(4).charAt(0) - 'A';
            int re = Integer.parseInt(matcher.group(5)) - 1;
            int sum = 0;
            for (int r = rs; r <= re ; r++) {
                for (int c = cs; c < ce; c++) {
                    sum += Integer.parseInt(sheet[r][c]);
                }
            }
            return sum;
        }
        
        return 0;
    }

    private static String evaluate(String value, String[][] sheet) {
        Matcher matcher1 = pattern1.matcher(value);
        Matcher matcher2 = pattern2.matcher(value);
        if (matcher1.find()){
            String c1 = matcher1.group(1);
            String r1 = matcher1.group(2);
            String sign = matcher1.group(3);
            String c2 = matcher1.group(4);
            String r2 = matcher1.group(5);
            String v1, v2;
            if (c1 != null){
                v1 = sheet[Integer.parseInt(r1) - 1][c1.charAt(0) - 'A'];
                if (v1.startsWith("=")){
                    v1 = evaluate(v1, sheet);
                }
            } else {
                v1 = r1;
            }

            if (c2 != null){
                v2 = sheet[Integer.parseInt(r2) - 1][c2.charAt(0) - 'A'];
                if (v2.startsWith("=")){
                    v2 = evaluate(v2, sheet);
                }
            } else {
                v2 = r2;
            }

            int d1 = Integer.parseInt(v1);
            int d2 = Integer.parseInt(v2);
            if (sign.equals("+")){
                return (d1 + d2) + "";
            }else {
                return (d1- d2) + "";
            }
        } else if (matcher2.find()) {
            String c1 = matcher2.group(1);
            String r1 = matcher2.group(2);
            String v;
            v = sheet[Integer.parseInt(r1) - 1][c1.charAt(0) - 'A'];
            if (v.startsWith("-")){
                v = evaluate(v, sheet);
            }
            return v;
        }
        return "0";
    }


}
