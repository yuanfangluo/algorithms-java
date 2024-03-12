package huawei;

import java.util.Scanner;

public class 不含101的数 {
    /*
    * 1 10
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int left  = scanner.nextInt();
            int right  = scanner.nextInt();

            System.out.println(dp(right)-dp(left-1));
        }
    }

    public static int dp(int num) {
        // 10 -> [1,0,1,0,0]
        String number_str = Integer.toBinaryString(num);

        Integer[] single_binary_nums = new Integer[number_str.length()];

        for (int i=0;i<number_str.length();i++) {
            single_binary_nums[i] = Integer.parseInt(number_str.charAt(i)+"");
        }

        int[][][] binary_dp = new int[single_binary_nums.length][2][2];

        return search(0, true, binary_dp, single_binary_nums, 0, 0);
    }

    public static int search(int p, boolean flag, int[][][] binary_dp, Integer[] single_binary_nums, int pre, int prepre) {
        if (p == single_binary_nums.length) {
            return 1;
        }

        if (!flag && binary_dp[p][pre][prepre] != 0) {
            return binary_dp[p][pre][prepre];
        }

        int index = flag ? single_binary_nums[p] : 1;
        int count = 0;

        for (int i = 0; i < index+1; i++) {
            if (i == 1 && pre == 0 && prepre == 1) {
                continue;
            }
            count += search(p + 1, flag && i == index, binary_dp, single_binary_nums, i, pre);
        }

        if (!flag) {
            binary_dp[p][pre][prepre] = count;
        }

        return count;
    }
}
