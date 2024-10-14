package Algorithms._4_其他常见算法技巧.数学运用技巧.如何高效进行模幂运算;

import java.util.Arrays;

// https://leetcode.cn/problems/super-pow/
public class _372_超级次方 {
    // b = [1,5,6,4]
    // a^[1,5,6,4]
    // = a^4 x a^[1, 5, 6, 0]
    // = a^4 x (a^[1, 5, 6])^10

    // superPow(a, [1,5,6,4])
    // = a^4 x （superPow(a, [1,5,6])）^10

    public int superPow(int a, int[] b) {
        // 递归的 base case
        if (b.length == 0)
            return 1;
        // 取出最后一个数
        int last = b[b.length - 1];
        int[] newArr = Arrays.copyOfRange(b, 0, b.length - 1);
        // 将原问题化简，缩小规模递归求解
        int part1 = mypow(a, last);
        int part2 = mypow(superPow(a, newArr), 10);
        // 合并出结果
        return part1 * part2 % base;
    }

    // 如何处理 mod 运算
    // 由于计算机的编码方式，形如 (a * b) % base这样的运算，
    // 乘法的结果可能导致溢出，我们希望找到一种技巧，能够化简这种表达式，避免溢出同时得到结果。

    // 比如在二分查找中，我们求中点索引时用 (l+r)/2 转化成 l+(r-l)/2，避免溢出的同时得到正确的结果。

    // 一个关于模运算的技巧
    // (a * b) % k = (a % k) * (b % k) % k
    // 换句话说，对乘法的结果求模，等价于先对每个因子都求模，然后对因子相乘的结果再求模。

    int base = 1337;

    // 计算 a 的 k 次方然后与 base 求模的结果
    int mypow(int a, int k) {
        // 对因子求模
        a %= base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            // 这里有乘法，是潜在的溢出点
            res *= a;
            // 对乘法结果求模
            res %= base;
        }
        return res;
    }

    // 如何高效求幂
    // 幂为奇数的时候 a^k = a^k-1 * a
    // 幂为偶数的时候 a^k = (a^k/2) * (a^k/2)
     int mypow2(int a, int k) {
        if (k == 0) return 1;
        a %= base;
        if (k % 2 == 1) {
            // k 是奇数
            return (a * mypow(a, k - 1)) % base;
        } else {
            // k 是偶数
            int sub = mypow(a, k / 2);
            return (sub * sub) % base;
        }
    }
    // 虽然对于题目，这个优化没有啥特别明显的效率提升，但是这个求幂算法已经升级了，
    // 以后如果别人让你写幂算法，起码要写出这个算法

}
