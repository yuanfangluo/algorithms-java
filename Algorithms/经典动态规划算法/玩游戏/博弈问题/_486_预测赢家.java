package Algorithms.经典动态规划算法.玩游戏.博弈问题;

// https://leetcode.cn/problems/predict-the-winner/
public class _486_预测赢家 {
    class Solution1 {
        class Pair {
            int fir, sec;

            Pair(int fir, int sec) {
                this.fir = fir;
                this.sec = sec;
            }
        }

        /* 返回游戏最后先手和后手的得分之差 */
        int stoneGame(int[] piles) {
            int n = piles.length;
            // 初始化 dp 数组
            Pair[][] dp = new Pair[n][n];
            for (int i = 0; i < n; i++)
                for (int j = i; j < n; j++)
                    dp[i][j] = new Pair(0, 0);

            // 填入 base case
            for (int i = 0; i < n; i++) {
                dp[i][i].fir = piles[i];
                dp[i][i].sec = 0;
            }

            // 倒着遍历数组
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    // 先手选择最左边或最右边的分数
                    int left = piles[i] + dp[i + 1][j].sec;
                    int right = piles[j] + dp[i][j - 1].sec;

                    // 套用状态转移方程
                    // 先手肯定会选择更大的结果，后手的选择随之改变
                    if (left > right) {
                        dp[i][j].fir = left;
                        dp[i][j].sec = dp[i + 1][j].fir;
                    } else {
                        dp[i][j].fir = right;
                        dp[i][j].sec = dp[i][j - 1].fir;
                    }
                }
            }

            Pair res = dp[0][n - 1];
            return res.fir - res.sec;
        }
    }

    class Solution2 {
        public boolean predictTheWinner(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            // dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，即在下标范围 [i,j] 中，当前玩家与另一个玩家的分数之差的最大值(最优解)
            // dp[i][j]= max(nums[i]−dp[i+1][j],nums[j]−dp[i][j−1])
            for (int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
            }

            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
            return dp[0][n - 1] >= 0;
        }
    }
}