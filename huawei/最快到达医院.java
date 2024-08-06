package huawei;

import java.util.Scanner;

public class 最快到达医院 {
    /*
    *
    * 50 5 500 30 90 // A医院的距离，B医院的距离，计程车速度，上车等待时间，步行速度
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int m = scanner.nextInt();
            int l = scanner.nextInt();
            int n = scanner.nextInt();

            int time1 = x * 1000 / m + l;
            int time2 = y * 1000 / n;

            if (time1 == time2){
                System.out.println("same");
            } else if (time1 > time2){
                System.out.println("walk");
            } else  {
                System.out.println("taxi");
            }

        }
    }
}
