package huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Algorithms.other.零一背包问题;

public class 优选核酸检测点 {


    /*
    * 找到截止日期前最优的检测点
    * 10 30
    * 14 50
    * 3
    * 1 10 19 // (id, 距离，当前人数)
    * 2 8 20
    * 3 21 3
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int start = scanner.nextInt() * 60 + scanner.nextInt();
            int end = scanner.nextInt() * 60 + scanner.nextInt();
            int n = scanner.nextInt();

            Point[] points = new Point[n];

            for (int i = 0; i < n; i++) {
                Point point = new Point();
                point.id = scanner.nextInt();
                point.dis = scanner.nextInt();
                point.que = scanner.nextInt();

                point.pay = point.dis * 10;
                point.time = getTime(start, point);
                points[i] = point;
            }
            solution(start, end, points);
        }
    }

    private static void solution(int start, int end, Point[] points) {
        List<Point> res = Arrays.stream(points)
                .filter(p -> (start + p.time) < end)
                .sorted((p1, p2) -> {
                    if (p1.time != p2.time){ // 也就是先测完的时间
                        return p1.time - p2.time;
                    } else { // 时间一样的话，花费最小
                        return p1.pay - p2.pay;
                    }
                }).toList();

        System.out.println(res.size());

        for (Point p: res
             ) {
            System.out.println(p);
        }
    }

    static int[] add8_10 = {3, 480, 600}; // {每分钟排队人数，8点，10点}
    static int[] add12_14 = {10, 720, 840}; // {每分钟排队人数，8点，10点}


    // 检测时的时间：去的时间+排队的时间
    private static int getTime(int start, Point point) {
        int time = 0;
        // 累加路程时间
        time += point.dis * 10;
        // 去除路程中的排队人数
        // 每公里花费10分钟，每检测一个人是1分钟
        int goTime = point.dis * 10;
        point.que = Math.max(0, point.que - goTime * 1);

        // 到检测点的时间
        int on = start + goTime;

        // 8点前到
        if (on <= add8_10[1]) {
            return add8_10[1] - start;
        }

        // 8点-10点到,每分钟排队3人
        if (on <= add8_10[2]){
            point.que += (on - add8_10[1]) * add8_10[0] - (on - add8_10[1]);
            return time + point.que;
        }

        // 10-12点到,不排队
        if (on <= add12_14[1]) {
            return  time + point.que;
        }

        // 12-14点到
        if (on <= add12_14[2]){
            point.que += (on - add12_14[1]) * add12_14[0] - (on - add12_14[1]);
            return time += point.que;
        }

        // 14点以后
        return time + point.que;

    }

    static class Point {
        int id;
        int dis;// 距离
        int que; // 当前人数
        int pay; // 花费
        int time; //

        @Override
        public String toString() {
            return id + " " + time + " " + pay;
        }
    }
}
