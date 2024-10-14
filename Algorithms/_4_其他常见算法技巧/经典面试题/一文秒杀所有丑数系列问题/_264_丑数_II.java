package Algorithms._4_其他常见算法技巧.经典面试题.一文秒杀所有丑数系列问题;

// https://leetcode.cn/problems/ugly-number-ii/?show=1
public class _264_丑数_II {
    // 思路一：合并有序链表
    class solution {
        public int nthUglyNumber(int n) {
            // 可以理解为三个指向有序链表头结点的指针
            int p2 = 1, p3 = 1, p5 = 1;
            // 可以理解为三个有序链表的头节点的值
            int product2 = 1, product3 = 1, product5 = 1;
            // 可以理解为最终合并的有序链表（结果链表）
            int[] ugly = new int[n + 1];
            // 可以理解为结果链表上的指针
            int p = 1;

            // 开始合并三个有序链表
            while (p <= n) {
                // 取三个链表的最小结点
                int min = Math.min(Math.min(product2, product3), product5);
                // 接到结果链表上
                ugly[p] = min;
                p++;
                // 前进对应有序链表上的指针
                if (min == product2) {
                    product2 = 2 * ugly[p2];
                    p2++;
                }
                if (min == product3) {
                    product3 = 3 * ugly[p3];
                    p3++;
                }
                if (min == product5) {
                    product5 = 5 * ugly[p5];
                    p5++;
                }
            }
            // 返回第 n 个丑数
            return ugly[n];
        }
    }

    // 思路二：动态规划
    class solution2 {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
                dp[i] = Math.min(Math.min(num2, num3), num5);
                if (dp[i] == num2) {
                    p2++;
                }

                if (dp[i] == num3) {
                    p3++;
                }

                if (dp[i] == num5) {
                    p5++;
                }
            }
            return dp[n];
        }
    }
}
