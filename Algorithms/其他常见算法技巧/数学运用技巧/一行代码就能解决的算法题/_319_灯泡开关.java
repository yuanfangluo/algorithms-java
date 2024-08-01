package Algorithms.其他常见算法技巧.数学运用技巧.一行代码就能解决的算法题;

// https://leetcode.cn/problems/bulb-switcher/
public class _319_灯泡开关 {
    // 思路二：数学
    // 对于第 i 个灯泡，它会在第 i 轮被操作，也就是说当 i 为平方数时，它才会被操作奇数次。
    // 因此，我们只需要找出 1 到 n 中有多少个平方数即可。
    // 由于 1 到 n 是连续的整数，因此我们可以开方后再取整，即可得到结果。    
    int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
