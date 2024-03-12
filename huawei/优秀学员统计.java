package huawei;

import java.util.HashMap;
import java.util.List;

import java.util.Scanner;
import java.util.stream.Collectors;

public class 优秀学员统计 {
    /*
    *
    *
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt(); // 员工数
            scanner.nextLine();
            String counts = scanner.nextLine(); // 每天打卡的员工数
            String[] records = new String[30]; // 每天打卡的员工id
            for (int i = 0; i < records.length; i++) {
                records[i] = scanner.nextLine();
            }

            String res = solution(n, counts, records);
            System.out.println(res);
        }
    }
    private static class Clock implements Comparable<Clock> {
        int id; // 员工id
        int times; // 打卡次数
        int earliestTime = Integer.MAX_VALUE; // 最早打卡时间

        @Override
        public int compareTo(Clock o) {
            if (this.times == o.times){
                if (this.earliestTime == o.earliestTime) {
                    // 按照id从小到大排序
                    return this.id - o.id;
                } else {
                    // 按照最早打卡时间从小到大排序
                    return this.earliestTime - o.earliestTime;
                }
            } else {
                // 按照打卡次数从大到小排序
                return o.times - this.times;
            }
        }
    }


    private static String solution(int n, String counts, String[] records) {
        HashMap<String, Clock> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            // 单条打卡员工ids
            String record = records[i];
            String[] ids = record.split(" ");

            for (String id: ids) {
                if (!map.containsKey(id)){
                    Clock clock = new Clock();
                    clock.id = Integer.parseInt(id);
                    clock.earliestTime = Math.min(i, clock.earliestTime);
                    map.put(id, clock);
                }
                Clock clock = map.get(id);
                clock.times += 1;
                map.put(id, clock);
            }
        }
        List<Clock> list = map.values().stream().sorted().collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        for (int i = 0;  i< list.size() && i < 5; i++) {
            builder.append(list.get(i).id).append(" ");
        }

        return builder.substring(0, builder.length() - 1);
    }
}
