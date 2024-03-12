package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 计算数组中心位置 {
    /*
    * 2 5 3 6 5 6
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String[] strs = scanner.nextLine().split(" ");
            int len = strs.length;
            int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

            int res = solution(len, nums);
            System.out.println(res);
        }
    }

    private static int solution(int len, int[] nums) {
        int[] left = new int[len]; // 左侧的乘积
        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        int[] right = new int[len]; // 右侧的乘积
        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }

        int res = -1;
        if (right[1] == 1) {
            res = 0;
        } else {
            for (int i = 1; i < len; i++) {
                if (i == len -1){
                    if (left[i - 2] == 1){
                        res = len - 1;
                    }
                } else if (left[i - 1] == right[i + 1]) {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }


}
