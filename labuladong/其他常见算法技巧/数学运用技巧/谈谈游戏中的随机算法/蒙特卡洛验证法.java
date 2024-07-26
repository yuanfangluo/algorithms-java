package labuladong.其他常见算法技巧.数学运用技巧.谈谈游戏中的随机算法;

import java.util.Arrays;

public class 蒙特卡洛验证法 {
    // 大力出奇迹
    public static void main(String[] args) {
        // 在 [12, 22) 中随机选 3 个数
        int lo = 12, hi = 22, k = 3;
        // 记录每个元素被选中的次数
        int[] count = new int[hi - lo];
        // 重复 10 万次
        int N = 1000000;
        for (int i = 0; i < N; i++) {
            水塘抽样算法 sample = new 水塘抽样算法();
            int[] res = sample.sample(lo, hi, k);
            for (int elem : res) {
                // 对随机选取的元素进行记录
                count[elem - lo]++;
            }
        }
        System.out.println(Arrays.toString(count));
    }
}
