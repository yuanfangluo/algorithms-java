package Algorithms.其他常见算法技巧.数学运用技巧.一行代码就能解决的算法题;

// https://leetcode.cn/problems/nim-game/
public class _292_Nim游戏 {
    boolean canWinNim(int n) {
        // 如果上来就踩到 4 的倍数，那就认输吧
        // 否则，可以把对方控制在 4 的倍数，必胜
        return n % 4 != 0;
    }
}
