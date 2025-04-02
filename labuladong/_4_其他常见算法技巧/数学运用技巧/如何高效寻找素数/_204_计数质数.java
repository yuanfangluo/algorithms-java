package labuladong._4_其他常见算法技巧.数学运用技巧.如何高效寻找素数;

import java.util.Arrays;

// https://leetcode.cn/problems/count-primes/
public class _204_计数质数 {
    // 素数筛选法
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            // 0 和 1 不是素数
            isPrime[0] = isPrime[1] = false;
            // 枚举到 i * i < n 即可
            // 因为如果 i 是合数，那么它一定有一个比 i 小的因子 j，且 j * j < i
            // 所以 j * j < i * i 一定成立
            // 因此，我们只需要枚举 [2, \sqrt{n}] 区间内的数即可
            for (int i = 2; i * i < n; i++)
                if (isPrime[i])
                    // 让 j 从 i 的平方开始遍历，每次增加 i
                    for (int j = i * i; j < n; j += i)
                        isPrime[j] = false;

            int count = 0;
            for (int i = 2; i < n; i++)
                if (isPrime[i])
                    count++;

            return count;
        }
    }
}
