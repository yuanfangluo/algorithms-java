package Algorithms.其他常见算法技巧.数学运用技巧.常用的位操作;

public class 几个有趣的位操作 {
    public static void main(String[] args) {
    }

    // 利用或操作 | 和空格将英文字符转换为小写
    private static char lowerCase(char c) {
        return (char) (c | ' ');
    }

    // 利用与操作 & 和下划线将英文字符转换为大写
    private static char upperCase(char c) {
        return (char) (c & '_');
    }

    // 利用异或操作 ^ 和空格将英文字符的大小写互换
    private static char swapCase(char c) {
        return (char) (c ^ ' ');
    }

    // 不用临时变量交换两个数
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    // 加一
    private static int plusOne(int num) {
        return -~num;
    }

    // 减一
    private static int minusOne(int num) {
        return ~-num;
    }

    // 判断两个数是否异号
    private static boolean isOpposite(int a, int b) {
        return (a ^ b) < 0;
    }

    // 在 单调栈解题套路 中介绍过环形数组，其实就是利用求模（余数）的方式让数组看起来头尾相接形成一个环形，永远都走不完
    // arr[index % arr.length]

    // 模运算 % 对计算机来说其实是一个比较昂贵的操作，所以我们可以用 & 运算来求余数
    // arr[index & (arr.length - 1)]

    // 注意这个技巧只适用于数组长度是 2 的幂次方的情况，比如 2、4、8、16、32 以此类推。
    // 因为如果数组长度不是 2 的幂次方，那么 (index & (arr.length - 1)) 的值就会超过数组的长度，导致数组下标越界。
    // 但是如果数组长度是 2 的幂次方，那么 (index & (arr.length - 1)) 的值就会保持在数组的长度范围内，不会出现数组下标越界的情况。
    
    // 那问题来了，现在是不断地 index++，你做到了循环遍历。但如果不断地 index--，还能做到环形数组的效果吗？
    // 答案是，如果你使用 % 求模的方式，那么当 index 小于 0 之后求模的结果也会出现负数，你需要特殊处理。
    // 但通过 & 与运算的方式，index 不会出现负数，依然可以正常工作

    // n & (n-1) 的运用
    // 对于一个二进制数 n，n & (n-1) 的效果是将 n 的二进制表示中的最后一个 1 变成 0
    // 例如，对于二进制数 10110100，n & (n-1) 的结果是 10110000


    // a ^ a = 0 的运用
    // 一个数和它本身做异或运算结果为 0，即 a ^ a = 0；
    // 一个数和 0 做异或运算的结果为它本身，即 a ^ 0 = a。
    // 异或运算满足交换律和结合律，即 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b。

    
}
