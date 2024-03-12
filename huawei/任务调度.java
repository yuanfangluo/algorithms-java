package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 任务调度 {
    /*
     1 3 5 1
     2 1 5 10
     3 2 7 12
     4 3 2 20
     5 4 9 21
     6 4 2 22
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            List<Task> tasks = new ArrayList<>();

            while (true){
                String line = scanner.nextLine();
                if (line.isEmpty()){
                    break;
                }

                String[] split = line.split(" ");
                Task task = new Task(
                        Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2]),
                        Integer.parseInt(split[3])

                );

                tasks.add(task);
            }

            solution(tasks);
        }
    }

    private static void solution(List<Task> tasks) {
        // 时间起始
        int time = 0;
        ArrayList<Task> waiting = new ArrayList<>();
        while (tasks.size() > 0){
            Task cur = find(tasks, time);
            if (cur != null){
                waiting.add(cur);
                waiting.sort(Task::compareTo);
            } else {
                if (waiting.size() != 0){
                    cur = waiting.get(0);
                }
            }

            if (cur != null){
                cur.time -= 1; // 一秒一秒地执行
                if (cur.time.equals(0)){
                    System.out.println(cur.id + " " + (time + 1));
                    tasks.remove(cur);
                    waiting.remove(cur);
                }
            }
            time++;
        }
    }

    /*
    * 找此时到达的任务
    * */
    private static Task find(List<Task> tasks, int time) {
        for (Task task: tasks
             ) {
            if (task.start.equals(time)){
                return task;
            }
        }
        return null;
    }

    static class Task implements Comparable<Task> {
        Integer id;
        Integer level;
        Integer time;
        Integer start;

        public Task(Integer id, Integer level, Integer time, Integer start) {
            this.id = id;
            this.level = level;
            this.time = time;
            this.start = start;
        }


        @Override
        public int compareTo(Task o) {
            return o.level - this.level;
        }
    }

}
