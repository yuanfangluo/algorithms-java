package huawei;

import java.util.*;

public class 积木最远距离 {

    /*
    * 2
    * 1
    * 2
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int count = scanner.nextInt();

            int[] nums = new int[count];
            for (int i = 0; i < count; i++) {
                nums[i] = scanner.nextInt();
            }

            int res = solution(count, nums);
            System.out.println(res);

        }
    }

    private static int solution(int count, int[] nums) {
        HashMap<Integer, List<Integer>> blocks = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int num = nums[i];
            List<Integer> block; // 存放相同数字的位置
            if (blocks.containsKey(num)){
                block = blocks.get(num);
            } else {
                block = new ArrayList<>();
            }
            block.add(i);
            blocks.put(num, block);
        }

        int max_distance = -1;
        for (Map.Entry<Integer, List<Integer>> block:
                blocks.entrySet()) {
            if (block.getValue().size() > 1) { // 表示超过2个相同的数字
                max_distance = Math.max(max_distance, Collections.max(block.getValue()) - Collections.min(block.getValue()));
            }
        }
        return max_distance;
    }


}
