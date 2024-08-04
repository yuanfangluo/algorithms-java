// https://leetcode.cn/problems/trapping-rain-water/?show=1
public class _42_接雨水 {
    /*
     * 对于任意一个位置 i，能够装的水为：
     * water[i] = min(
     * # 左边最高的柱子
     * max(height[0..i]),
     * # 右边最高的柱子
     * max(height[i..end])
     * ) - height[i]
     */

    // 时间复杂度 O(N^2)，空间复杂度 O(1)。
    // 但是很明显这种计算 r_max 和 l_max 的方式非常笨拙，一般的优化方法就是备忘录
    class Solution1 {
        public int trap(int[] height) {
            int n = height.length;
            int res = 0;
            // 首尾两个位置装不了水，剔除掉这两个点
            for (int i = 1; i < n - 1; i++) {
                int l_max = 0, r_max = 0;
                // 找右边最高的柱子
                for (int j = i; j < n; j++)
                    r_max = Math.max(r_max, height[j]);
                // 找左边最高的柱子
                for (int j = i; j >= 0; j--)
                    l_max = Math.max(l_max, height[j]);
                // 如果自己就是最高的话，
                // l_max == r_max == height[i]
                res += Math.min(l_max, r_max) - height[i];
            }
            return res;
        }
    }

    // 使用备忘录优化时间复杂度
    // 之前的暴力解法，不是在每个位置 i 都要计算 r_max 和 l_max 吗？
    // 我们直接把结果都提前计算出来，别傻不拉几的每次都遍历，这时间复杂度不就降下来了嘛。
    // 我们开两个数组 r_max 和 l_max 充当备忘录，
    // l_max[i] 表示位置 i 左边最高的柱子高度，r_max[i] 表示位置 i 右边最高的柱子高度。

    // 把时间复杂度降低为 O(N)，已经是最优了，但是空间复杂度是 O(N)。
    class Solution2 {
        public int trap(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            int n = height.length;
            // 存储结果
            int res = 0;
            // 数组充当备忘录
            int[] l_max = new int[n];
            int[] r_max = new int[n];
            // 初始化 base case
            l_max[0] = height[0];
            r_max[n - 1] = height[n - 1];
            // 从左向右计算 l_max
            for (int i = 1; i < n; i++)
                l_max[i] = Math.max(height[i], l_max[i - 1]);
            // 从右向左计算 r_max
            for (int i = n - 2; i >= 0; i--)
                r_max[i] = Math.max(height[i], r_max[i + 1]);
            // 计算答案
            for (int i = 1; i < n - 1; i++)
                res += Math.min(l_max[i], r_max[i]) - height[i];
            return res;
        }
    }

    // 能够把空间复杂度降低到 O(1)
    // 时间复杂度O(n)
    // 双指针解法
    class Solution3 {
        public int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int l_max = 0, r_max = 0;
    
            int res = 0;
            while (left < right) {
                // l_max 是 height[0..left] 中最高柱子的高度
                l_max = Math.max(l_max, height[left]);
                // r_max 是 height[right..end] 中最高柱子的高度
                r_max = Math.max(r_max, height[right]);

                // 我们只在乎 min(l_max, r_max)。

                // 我们已经知道 l_max < r_max 了，至于这个 r_max 是不是右边最大的，不重要。
                // 重要的是 height[i] 能够装的水只和较低的 l_max 之差有关：
                // res += min(l_max, r_max) - height[i]
                if (l_max < r_max) {
                    res += l_max - height[left];
                    left++;
                } else {
                    res += r_max - height[right];
                    right--;
                }
            }
            return res;
        }
    }
}
