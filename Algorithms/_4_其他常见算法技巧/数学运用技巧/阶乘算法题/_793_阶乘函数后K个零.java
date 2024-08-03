package Algorithms._4_其他常见算法技巧.数学运用技巧.阶乘算法题;

// https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/
public class _793_阶乘函数后K个零 {
    // 搜索有多少个 n 满足 trailingZeroes(n) == K，
    // 其实就是在问满足条件的 n 最小是多少，最大是多少，
    // 最大值和最小值一减，就可以算出来有多少个 n 满足条件了
    // 那不就是 二分查找 中「搜索左侧边界」和「搜索右侧边界」这两个事儿嘛？

    // 在区间 [0, LONG_MAX] 中寻找满足 trailingZeroes(n) == K 的左侧边界和右侧边界。
    // 二分查找算法框架，搜索左侧边界和右侧边界的框架

    class Solution {
        public int preimageSizeFZF(int k) {
            // 左边界和右边界之差 + 1 就是答案
            return (int) (right_bound(k) - left_bound(k) + 1);
        }

        /* 搜索 trailingZeroes(n) == K 的左侧边界 */
        long left_bound(int target) {
            long lo = 0, hi = Long.MAX_VALUE;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                if (trailingZeroes(mid) < target) {
                    lo = mid + 1;
                } else if (trailingZeroes(mid) > target) {
                    hi = mid;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        /* 搜索 trailingZeroes(n) == K 的右侧边界 */
        long right_bound(int target) {
            long lo = 0, hi = Long.MAX_VALUE;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                if (trailingZeroes(mid) < target) {
                    lo = mid + 1;
                } else if (trailingZeroes(mid) > target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo - 1;
        }

        // 逻辑不变，数据类型全部改成 long
        long trailingZeroes(long n) {
            long res = 0;
            for (long d = n; d / 5 > 0; d = d / 5) {
                res += d / 5;
            }
            return res;
        }
    }
}
