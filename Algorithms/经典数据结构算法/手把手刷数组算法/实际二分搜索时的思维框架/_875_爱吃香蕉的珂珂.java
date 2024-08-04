package Algorithms.经典数据结构算法.手把手刷数组算法.实际二分搜索时的思维框架;

// https://leetcode.cn/problems/koko-eating-bananas/description/
public class _875_爱吃香蕉的珂珂 {
    // 珂珂每小时最多只能吃一堆香蕉，如果吃不完的话留到下一小时再吃；如果吃完了这一堆还有胃口，也只会等到下一小时才会吃下一堆。
    // 他想在警卫回来之前吃完所有香蕉，让我们确定吃香蕉的最小速度 K
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        // 注意，我选择左闭右开的二分搜索写法，right 是开区间，所以再加一
        int right = 1000000000 + 1;
        // 这就是搜索左侧边界的二分搜索
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) == H) {
                // 搜索左侧边界，则需要收缩右侧边界
                right = mid;
            } else if (f(piles, mid) < H) {
                // 需要让 f(x) 的返回值大一些
                right = mid;
            } else if (f(piles, mid) > H) {
                // 需要让 f(x) 的返回值小一些
                left = mid + 1;
            }
        }
        return left;
    }

    // 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    // f(x) 随着 x 的增加单调递减
    long f(int[] piles, int x) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }
}
