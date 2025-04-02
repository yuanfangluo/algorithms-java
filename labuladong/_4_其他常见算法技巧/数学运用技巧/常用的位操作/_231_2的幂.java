package labuladong._4_其他常见算法技巧.数学运用技巧.常用的位操作;

// https://leetcode.cn/problems/power-of-two/
public class _231_2的幂 {
    // 一个数如果是 2 的指数，那么它的二进制表示一定只含有一个 1：

    // 如果使用 n & (n-1) 的技巧就很简单了（注意运算符优先级，括号不可以省略）：
    // 2^0 = 1 = 0b0001
    // 2^1 = 2 = 0b0010
    // 2^2 = 4 = 0b0100
    
    boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }
}
