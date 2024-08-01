package Algorithms.经典数据结构算法.手把手刷数组算法.差分数组;

/*
* https://leetcode.cn/problems/corporate-flight-bookings/
*
* */
public class _1109_航班预订统计 {

    int[] corpFlightBookings11(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            df.increment(i, j, val);
         }

        return df.result();

    }


    int[] corpFlightBookings(int[][] bookings, int n) {
        // nums 初始化为全 0
        int[] nums = new int[n];

        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            // 注意转成数组索引要减一哦
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对区间 nums[i..j] 增加 val
            df.increment(i, j, val);
        }
        // 返回最终的结果数组
        return df.result();
    }

}
