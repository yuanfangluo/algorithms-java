package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 快速开租建站 {

    public static void main(String[] args) {
        /*
        * 5
        * 5
        * 0 4
        * 1 2
        * 1 3
        * 2 3
        * 2 4
        *
        * */
        try(Scanner scanner = new Scanner(System.in)){
            int taskNum = scanner.nextInt();
            int relationsNum = scanner.nextInt();

            int[][] relations = new int[relationsNum][2];

            for (int i = 0; i < relationsNum; i++) {
                relations[i][0] = scanner.nextInt();
                relations[i][1] = scanner.nextInt();
            }

            System.out.println(solution(relations, taskNum));

        }
    }

    private static int solution(int[][] relations, int taskNum) {
        HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();
        int[] inDegree = new int[taskNum];

        for (int[] relation: relations) {
            int a = relation[0];
            int b = relation[1];
            next.putIfAbsent(a, new ArrayList<>());
            next.get(a).add(b);
            inDegree[b]++;
        }

        LinkedList<Integer[]> queue = new LinkedList<>();
        int t = 1;

        for (int i = 0; i < taskNum; i++) {
            if (inDegree[i] == 0) {
                queue.add(new Integer[]{i, t});
            }
        }

        while (queue.size() > 0) {
            Integer[] tmp = queue.removeFirst();
            int task = tmp[0];
            int time = tmp[1];
            if (next.containsKey(task) && next.get(task).size() >0){
                for (Integer nxt: next.get(task)
                     ) {
                    if (--inDegree[nxt] == 0){
                        t = time +1;
                        queue.add(new Integer[]{nxt, t});
                    }
                }
            }
        }

    return t;
    }

}
