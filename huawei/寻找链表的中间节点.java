package huawei;

import java.util.*;

public class 寻找链表的中间节点 {
    public static void main(String[] args) {
        /*
        * 00100 4
        * 00000 4 -1
        * 00100 1 12309
        * 33218 3 00000
        * 12309 2 33218
        *
        * */
        try (Scanner scanner = new Scanner(System.in)){
            int head = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();
            Map<Integer, int[]> link = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                int address = scanner.nextInt();
                int data = scanner.nextInt();
                int next = scanner.nextInt();
                link.put(address, new int[]{data, next});
            }

            int res = solution(head, link);
            System.out.println(res);
        }
    }

    private static int solution(int head, Map<Integer,int[]> link) {
        if (link.size() == 0){
            return -1;
        }

        List<Integer> data = new ArrayList<>();
        int next = head;
        while (link.containsKey(next)){
            int[] node = link.get(next);
            data.add(node[0]);
            next = node[1];
        }
        return data.get((data.size() / 2));
    }
}
