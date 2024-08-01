package Algorithms.经典数据结构算法.手把手刷数组算法.差分数组;

/*
* https://leetcode.cn/problems/car-pooling/
*
* */
public class _1094_拼车 {

    public boolean carPooling11(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference df = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            df.increment(i, j, val);
        }

        int[] res = df.result();

        for (int i : res) {
            if (capacity < i) {
                return false;
            }
        }

        return true;
    }


    public boolean carPooling(int[][] trips, int capacity) {
        // 最多有 1000 个车站
        int[] nums = new int[1001];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] trip : trips) {
            // 乘客数量
            int val = trip[0];
            // 第 trip[1] 站乘客上车
            int i = trip[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            // 进行区间操作
            df.increment(i, j, val);
        }

        int[] res = df.result();

        // 客车自始至终都不应该超载
        for (int i = 0; i < res.length; i++) {
            if (capacity < res[i]) {
                return false;
            }
        }
        return true;
    }
}
