package labuladong.Array.滑动窗口.扩展;

import java.util.HashSet;

/*
* https://leetcode.cn/problems/contains-duplicate-ii/?show=1
*
* */
public class _219_存在重复元素_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right = 0;
        HashSet<Integer> window = new HashSet<>();
        // 滑动窗口算法框架，维护一个大小为 k 的窗口
        while (right < nums.length) {
            // 扩大窗口
            if (window.contains(nums[right])) {
                return true;
            }
            window.add(nums[right]);
            right++;

            if (right - left > k) {
                // 当窗口的大小大于 k 时，需要缩小窗口
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
