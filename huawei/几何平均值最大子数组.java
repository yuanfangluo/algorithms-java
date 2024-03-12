package huawei;

import java.math.BigDecimal;
import java.util.Scanner;

public class 几何平均值最大子数组 {
    /*
    * 3 2
    * 2
    * 2
    * 3
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int N = scanner.nextInt(); // 表示nums的个数
            int L = scanner.nextInt(); // 数组的最小长度

            double[] nums = new double[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextDouble();
            }

            System.out.println(soultion(N, L, nums));
        }
    }

    private static int index;
    private static double max; // 最大几何平均值

    private static String soultion(int n, int l, double[] nums) {
        int resIndex = 0;
        int resLen = 0;

        for (int i = l; i <= n; i++) {
            if (handle(i, nums)){
                resIndex = index;
                resLen = i;
            }
        }
        return resIndex + " " + resLen;
    }

    /*
    *
    * 是否满足最大几何平均值
    * */
    private static boolean handle(int len, double[] nums) {
        double maxInLen = 1; // len长度数组的最大乘积
        for (int i = 0; i < len; i++) {
            BigDecimal num1 = new BigDecimal(String.valueOf(maxInLen));
            BigDecimal num2 = new BigDecimal(String.valueOf(nums[i]));
            maxInLen = num1.multiply(num2).doubleValue();
        }

        index = 0; // 初始化索引位置
        double count = maxInLen; // 各数组中数字的乘积
        for (int i = len; i < nums.length; i++) {
            count *= nums[i] / nums[i - len];

            if (count > maxInLen){
                index = i - len + 1;
                maxInLen = count;
            }
        }

        double CFG = Math.pow(maxInLen, (double)  1/ len);

        if (CFG > max){
    max = CFG;
    return true;
        }
return false;
    }
}
