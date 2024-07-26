package labuladong.经典动态规划算法.贪心类型问题.跳跃游戏;

import java.util.Arrays;

// https://leetcode.cn/problems/jump-game-ii/
public class _45_跳跃游戏_II {
    // 暴力穷举所有可能的跳法，通过备忘录 memo 消除重叠子问题，取其中的最小值最为最终答案
    class Solution1 {
        int[] memo;

        // 主函数
        public int jump(int[] nums) {
            int n = nums.length;
            // 备忘录都初始化为 n，相当于 INT_MAX
            // 因为从 0 跳到 n - 1 最多 n - 1 步
            memo = new int[n];
            Arrays.fill(memo, n);

            return dp(nums, 0);
        }

        // 定义：从索引 p 跳到最后一格，至少需要 dp(nums, p) 步
        int dp(int[] nums, int p) {
            int n = nums.length;
            // base case
            if (p >= n - 1) {
                return 0;
            }
            // 子问题已经计算过
            if (memo[p] != n) {
                return memo[p];
            }

            int steps = nums[p];
            // 你可以选择跳 1 步，2 步...
            for (int i = 1; i <= steps; i++) {
                // 穷举每一个选择
                // 计算每一个子问题的结果
                int subProblem = dp(nums, p + i);
                // 取其中最小的作为最终结果
                memo[p] = Math.min(memo[p], subProblem + 1);
            }
            return memo[p];
        }
    }

    class Solution2 {
        int jump(int[] nums) {
            int n = nums.length;
            // i 和 end 标记了可以选择的跳跃步数，farthest 标记了所有选择 [i..end] 中能够跳到的最远距离
            int end = 0, farthest = 0;
            // jumps 记录了跳跃次数
            int jumps = 0;
            for (int i = 0; i < n - 1; i++) {
                // 遍历 [i..end] 区间，计算 farthest
                // 可以选择的跳跃步数是 [i..end] 中的任意一个
                // 选择可以跳最远的那个位置
                farthest = Math.max(nums[i] + i, farthest);
                // 已经到达了 end，需要跳了
                // 说明需要跳了，跳跃次数加一
                // 并更新 end
                // 下一轮的 end 是新的 farthest
                // 即下一轮的 [i..end] 就是 [end+1..farthest]
                // 即下一轮的 i 是 end + 1
                // 下一轮的 end 是新的 farthest
                if (end == i) {
                    jumps++;
                    end = farthest;
                }
            }
            return jumps;
        }
    }
}
