package Algorithms._3_经典动态规划算法.动态规划基本技巧.最长递增子序列;

import java.util.Arrays;

// https://leetcode.cn/problems/longest-increasing-subsequence/
public class _300_最长递增子序列 {
    // patience game 的纸牌游戏
    // 排序方法就叫做 patience sorting（耐心排序）
    
    class Solution {
        int lengthOfLIS(int[] nums) {
            int[] top = new int[nums.length];
            // 牌堆数初始化为 0
            int piles = 0;
            for (int i = 0; i < nums.length; i++) {
                // 要处理的扑克牌
                int poker = nums[i];
        
                /***** 搜索左侧边界的二分查找 *****/
                int left = 0, right = piles;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (top[mid] > poker) {
                        right = mid;
                    } else if (top[mid] < poker) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                /*********************************/
                
                // 没找到合适的牌堆，新建一堆
                if (left == piles) piles++;
                // 把这张牌放到牌堆顶
                top[left] = poker;
            }
            // 牌堆数就是 LIS 长度
            return piles;
        }
    }
    class Solution1 {
        int lengthOfLIS(int[] nums) {
            // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
            int[] dp = new int[nums.length];
            // base case：dp 数组全都初始化为 1
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])
                        dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }

            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 状态定义：dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                // base case：dp[i] 初始值为 1，因为以 nums[i] 结尾的最长递增子序列起码要包含它自己。
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    int pre = nums[j];
                    int cur = nums[i];
                    // 状态转移方程：如果 nums[i] > nums[j]，说明 nums[i] 可以接在 nums[j] 后面形成一个更长的递增子序列
                    if (pre < cur) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    // 状态转移方程：如果 nums[i] <= nums[j]，说明 nums[i] 无法接在 nums[j] 后面，保持以 nums[j]
                    // 结尾的最长递增子序列不变
                }
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }
}
