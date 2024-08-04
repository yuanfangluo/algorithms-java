package Algorithms.经典动态规划算法.玩游戏.四键键盘;

// https://leetcode.cn/problems/4-keys-keyboard/
public class _651_四个键的键盘 {
    // 最后一次按键要么是 A 要么是 C-V
    // 对于「按 A 键」这种情况，就是状态 i - 1 的屏幕上新增了一个 A 而已，很容易得到结果：dp[i] = dp[i - 1] + 1;
    // 但是，如果要按 C-V，还要考虑之前是在哪里 C-A C-C 的。
    // 刚才说了，最优的操作序列一定是 C-A C-C 接着若干 C-V，所以我们用一个变量 j 作为若干 C-V 的起点。
    // 那么 j 之前的 2 个操作就应该是 C-A C-C 了：

    class Solution {
        public int maxA(int N) {
            int[] dp = new int[N + 1];
            dp[0] = 0;
            for (int i = 1; i <= N; i++) {
                // 按 A 键
                dp[i] = dp[i - 1] + 1;
                for (int j = 2; j < i; j++) {
                    // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                    // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                    dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
                }
            }
            // N 次按键之后最多有几个 A？
            return dp[N];
        }
    }
}
