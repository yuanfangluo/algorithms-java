package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class 最大平分数组 {
    /*
    * 7
    * 4 3 2 3 5 2 1
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt();

            LinkedList<Integer> link = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                link.add(scanner.nextInt());
            }
            System.out.println(solution(link, m));
        }
    }

    private static int solution(LinkedList<Integer> link, int m) {
        // 降序
        link.sort((a, b) -> b -a);
        
        int sum = 0;

        for (Integer ele: link
             ) {
            sum += ele;
        }
        
        while (m >= 1){
            if (canPart(link, sum, m)) return m;
            m--;
        }
        
        return 1;
    }

    private static boolean canPart(LinkedList<Integer> link, int sum, int m) {
        if (sum % m != 0) return false;

        int subSum = sum / m;

        if (subSum < link.get(0)) return false;

        while (link.size() > 0 && link.get(0) == subSum){
            link.removeFirst();
            m--;
        }

        int[] buckets = new int[m];

        return part(link, 0, buckets, subSum);
    }

    private static boolean part(LinkedList<Integer> link, int index, int[] buckets, int subSum) {
        if (index == link.size()) return true;

        int select = link.get(index);

        for (int i = 0; i < buckets.length; i++) {
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            if (select + buckets[i] <= subSum){
                buckets[i] += select;
                if (part(link, index + 1, buckets, subSum)) return true;
                buckets[i] -= select;
            }
        }
        return false;
    }
}
