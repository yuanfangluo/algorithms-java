package Algorithms.经典数据结构算法.手把手刷数组算法.差分数组;

/*
* https://leetcode.cn/problems/range-addition/
* 直接利用差分数组
* */
public class _370_区间加法 {

    int[] getModifiedArray11(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference df = new Difference(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }
        return df.result();
    }


    int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }

        return df.result();
    }
}
