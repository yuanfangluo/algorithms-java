package labuladong._3_经典动态规划算法.贪心类型问题.跳跃游戏;

// https://leetcode.cn/problems/jump-game/
public class _55_跳跃游戏 {
    // 请问通过题目中的跳跃规则，最多能跳多远？如果能够越过最后一格，返回 true，否则返回 false。

    public class Solution2 {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // 每一步都计算一下从当前位置最远能够跳到哪里，然后和一个全局最优的最远位置 farthest 做对比，
    // 通过每一步的最优解，更新全局最优解，这就是贪心。
    class Solution1 {
        boolean canJump(int[] nums) {
            int n = nums.length;
            int farthest = 0;
            for (int i = 0; i < n - 1; i++) {
                // 不断计算能跳到的最远距离
                farthest = Math.max(farthest, i + nums[i]);
                // 可能碰到了 0，卡住跳不动了
                if (farthest <= i) {
                    return false;
                }
            }
            return farthest >= n - 1;
        }
    }
}
