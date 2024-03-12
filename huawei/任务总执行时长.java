package huawei;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class 任务总执行时长 {
    /*
    * 1，,2，,3
    *
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            String[] strs = scanner.nextLine().split(",");
            int aTime = Integer.parseInt(strs[0]); // a任务耗时
            int bTime = Integer.parseInt(strs[1]); // b任务耗时
            int num = Integer.parseInt(strs[2]); // 总共任务

            Set<Integer> total = new TreeSet<>();

            for (int i = 0; i <= num; i++) { // 代码只执行A任务或者只执行B任务
                int res = aTime * (num - i) + i * bTime;
                total.add(res);
            }
            System.out.println(total);
        }
    }

}
