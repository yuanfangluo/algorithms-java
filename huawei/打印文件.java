package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 打印文件 {
    /*
    * 7
    * IN 1 1 // 进入，打印机1，优先级1
    * IN 1 2
    * IN 1 3
    * IN 2 1
    * OUT 1
    * OUT 2
    * OUT 2
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt(); // 操作的个数
            scanner.nextLine();
            String[] jobs = new String[n];
            for (int i = 0; i < n; i++) {
                jobs[i] = scanner.nextLine();
            }
            solution(jobs);
        }
    }

    private static void solution(String[] jobs) {
        HashMap<String, List<int[]>> printers = new HashMap<>();
        for (int i = 0; i < jobs.length; i++) {
            String[] splits = jobs[i].split(" ");
            String operation = splits[0];
            String printer = splits[1];
            if (operation.equals("IN")){
                int priority = Integer.parseInt(splits[2]);
                in(printers, printer, i + 1, priority);
            } else {
                String res = out(printers, printer);
                System.out.println(res);
            }
        }
    }

    // out 操作
    private static String out(HashMap<String, List<int[]>> printers, String printer){
        String res = "NULL";
//       打印机printer没有任务需要打印
        if (!printers.containsKey(printer)) {
            return res;
        }
        List<int[]> jobList = printers.get(printer);
        if (jobList.size() == 0) {
            return res;
        }

        jobList.sort((o1, o2)->o2[1] - o1[1]);
        // 取第一个
        int seq = jobList.get(0)[0];
        jobList.remove(0);
        return seq + "";
    }

    // in操作
    private static void in(HashMap<String, List<int[]>> printers, String printer, int seq, int priority){
        if (!printers.containsKey(printer)) {
            printers.put(printer, new ArrayList<>());
        }
        List<int[]> jobList = printers.get(printer);
        jobList.add(new int[]{seq, priority});
    }
}
