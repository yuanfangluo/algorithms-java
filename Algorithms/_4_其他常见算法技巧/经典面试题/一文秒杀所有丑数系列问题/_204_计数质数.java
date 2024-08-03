package Algorithms._4_其他常见算法技巧.经典面试题.一文秒杀所有丑数系列问题;

import java.util.Arrays;

// https://leetcode.cn/problems/count-primes/
public class _204_计数质数 {
    public static void main(String[] args) {

    }

    // 素数筛选法
    // 首先从 2 开始，我们知道 2 是一个素数，那么 2 × 2 = 4, 3 × 2 = 6, 4 × 2 = 8... 都不可能是素数了。
    // 然后我们发现 3 也是素数，那么 3 × 2 = 6, 3 × 3 = 9, 3 × 4 = 12... 也都不可能是素数了。

    // 第一版本
    int countPrimes1(int n) {
        boolean[] isPrime = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++)
            if (isPrime[i])
                // i 的倍数不可能是素数了
                for (int j = i * 2; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i])
                count++;

        return count;
    }

    // 由于因子的对称性，其中的 for 循环只需要遍历 [2,sqrt(n)] 就够了。
    // 这里也是类似的，我们外层的 for 循环也只需要遍历到 sqrt(n)

    // 内层的for循环也存在冗余计算
    // 比如n=25，i=5的时候算法会比哦啊就5x2 = 10，5x3 = 15等等数字
    // 但是这两个数字宜家被 i = 2， i = 3的 2 x 5和 3 x 5标记了
    // 我们可以稍微优化一下，，让j从i的平方开始遍历，而不是从 i * 2开始
    // 我们可以得到如下结果
    public int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i])
                count++;

        return count;
    }

    
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
