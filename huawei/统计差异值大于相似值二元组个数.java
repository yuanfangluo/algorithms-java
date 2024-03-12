package huawei;

import java.util.Scanner;

public class 统计差异值大于相似值二元组个数 {
    /*
    * 4
    * 4 3 5 2
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();;
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            int res = solution(n, nums);
            System.out.println(res);
        }
    }

    private static int solution(int n, int[] nums) {
        int count = 0;
        for (int i = 0; i < n -1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = nums[i];
                int b = nums[j];
                if ((a ^ b) > (a & b)){
                    count++;
                }
            }
        }
        return count;
    }

}
