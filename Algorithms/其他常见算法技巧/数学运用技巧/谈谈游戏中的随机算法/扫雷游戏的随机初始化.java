package Algorithms.其他常见算法技巧.数学运用技巧.谈谈游戏中的随机算法;

import java.util.Random;

public class 扫雷游戏的随机初始化 {
    // 在区间 [lo, hi) 中随机抽取 k 个数字
    int[] sample(int lo, int hi, int k) {
        Random r = new Random();
        int[] res = new int[k];

        // 前 k 个元素先默认选上
        for (int i = 0; i < k; i++) {
            res[i] = lo + i;
        }

        int i = k;
        // while 循环遍历数字区间
        while (i < hi - lo) {
            i++;
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = lo + i - 1;
            }
        }
        return res;
    }
}
