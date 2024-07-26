package labuladong.其他常见算法技巧.数学运用技巧.常用的位操作;

// https://leetcode.cn/problems/number-of-1-bits/
// 计算汉明权重（Hamming Weight）
public class _191_位1的个数 {
    // 就是让你返回 n 的二进制表示中有几个 1。
    // 因为 n & (n - 1) 可以消除最后一个 1，所以可以用一个循环不停地消除 1 同时计数，直到 n 变成 0 为止
    
    int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
