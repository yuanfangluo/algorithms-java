package huawei;

import java.util.Scanner;

public class 获取最大软件版本号 {
    /*
    * 2.5.1-C
    * 1.4.2-D
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            String v1 = scanner.nextLine();
            String v2 = scanner.nextLine();
            String res = solution(v1, v2);
            System.out.println(res);
        }
    }

    static class Version implements Comparable<Version> {
        int fst; // 主版本
        int scd; // 次版本
        int inc; // 增量版本
        String mil = ""; // 里程碑版本

        @Override
        public int compareTo(Version o) {
            if (this.fst != o.fst) {
                return this.fst - o.fst;
            } else if (this.scd != o.scd) {
                return this.scd - o.scd;
            } else if (this.inc != o.inc) {
                return this.inc - o.inc;
            } else {
                return this.mil.compareTo(o.mil);
            }
        }
    }

    private static String solution(String v1, String v2) {
        Version ver1 = parse(v1);
        Version ver2 = parse(v2);
        int c = ver1.compareTo(ver2);
        if (c == 0) {
            return v1.length() >= v2.length() ? v1 : v2;
        } else {
            return c > 0 ? v1 : v2;
        }
    }

    static Version parse(String ver){
        String[] spl1 = ver.split("\\.");
        Version v = new Version();
        v.fst = Integer.parseInt(spl1[0]);
        v.scd = Integer.parseInt(spl1[1]);
        if (spl1.length > 2) {
            String[] spl2 = spl1[2].split("-");
            v.inc = Integer.parseInt(spl2[0]);
            if (spl2.length>1) {
                v.mil = spl2[1];
            }
        }
        return v;
    }
}
