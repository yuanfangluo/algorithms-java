package huawei;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class 异常的打卡记录 {
    /*
    * 2
    * 100000,10,1,ABCD,ABCD
    * 100000,50,10,ABCD,ABCD
    * 工号，时间，打卡距离，实际设备号，注册设备号
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt(); // 打卡记录数量
            scanner.nextLine();
            String[] records = new String[n]; // 打卡记录数组
            for (int i = 0; i < n; i++) {
                records[i] = scanner.nextLine();
            }
            String res = solution(records);
            System.out.println(res);
        }
    }

    private static class Record {
        String id;
        int time;
        int distance;
        String actualDeviceNumber;
        String registerDeviceNumber;
        String src;

    }

    private static String solution(String[] records) {
        ArrayList<Record> list = new ArrayList<>(records.length);
        for (String record: records) {
            String[] split = record.split(",");
            Record r = new Record();
            r.id = split[0];
            r.time = Integer.parseInt(split[1]);
            r.distance = Integer.parseInt(split[2]);
            r.actualDeviceNumber = split[3];
            r.registerDeviceNumber = split[4];
            r.src = record;
            list.add(r);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Record cur = list.get(i);
            if (!cur.registerDeviceNumber.equals(cur.actualDeviceNumber)) {
                builder.append(cur.src).append(";");
                continue;
            }
            for (Record tmp: list) {
                if (Math.abs(cur.time - tmp.time) < 60 && Math.abs(cur.distance - tmp.distance) > 5) {
                    builder.append(cur.src).append(";");
                    break;
                }
            }
        }
        return builder.length() == 0 ? "null" : builder.substring(0, builder.length() -1); // 去除最后一个";"
    }
}
