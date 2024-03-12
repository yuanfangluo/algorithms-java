package huawei;

import java.util.*;

public class 通信误码 {
    /*
    * 7
    * 1 2 2 4 2 1 1
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }

            System.out.println(solution(n, ints));
        }
    }

    private static int solution(int n, int[] ints) {
        if (n == 0) return 0;
        // 出现误码次数最多的
        int maxCount = 0;

        Map<Integer, Integer> codeCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = codeCount.getOrDefault(ints[i], 0) + 1;
            maxCount = Math.max(maxCount, count);
            codeCount.put(ints[i], count);
        }

//        存放出现次数最多的误码
        Set<Integer> maxCode = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry: codeCount.entrySet()
             ) {
            if (entry.getValue() == maxCount) {
                maxCode.add(entry.getKey());
            }
        }

        int minLen = Integer.MAX_VALUE;
        for (Integer key: maxCode
             ) {
            int leftIndex = 0;
            int rightIndex = ints.length - 1;
            // 从左边找到第一个key
            while (ints[leftIndex] != key) {
                leftIndex++;
            }


            // 下面开始从右边开始
            while (ints[rightIndex] != key){
                rightIndex--;
            }

            if (leftIndex <= rightIndex){
                minLen = Math.min(minLen, rightIndex - leftIndex + 1);
            }

        }
        return minLen;
    }


}
