// https://leetcode.cn/problems/container-with-most-water/
public class _11_盛最多水的容器 {
    // min(height[left], height[right]) * (right - left)
    class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int res = 0;
            while (left < right) {
                // [left, right] 之间的矩形面积
                int cur_area = Math.min(height[left], height[right]) * (right - left);
                res = Math.max(res, cur_area);
                // 双指针技巧，移动较低的一边

                // 为什么移动较低的一边？
                // 不管移动左边还是右边，矩形的宽度一定减小
                // 因为如果移动较高的一边，那么矩形的宽度变小，高度不会增加，面积只会更小
                // 所以移动较低的一边，才有可能找到一个更高的高度，从而可能找到更大的面积
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return res;
        }
    }
}
