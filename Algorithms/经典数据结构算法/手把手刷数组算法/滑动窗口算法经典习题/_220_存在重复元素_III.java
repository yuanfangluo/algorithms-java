package Algorithms.经典数据结构算法.手把手刷数组算法.滑动窗口算法经典习题;

import java.util.TreeSet;

/*
* https://leetcode.cn/problems/contains-duplicate-iii/?show=1
*
* 1. 什么时候扩大窗口？
* 当窗口大小 小于等于 indexDiff 时
* 2. 什么时候缩小窗口？
* 当窗口大小 大于 indexDiff 时
* 3. 什么时候得到一个合法的答案？
* 当窗口大小小于等于 indexDiff ，且窗口中存在两个不同元素之差小于 valueDiff，得到一个答案
*
* 那么如何在窗口 [left, right) 中快速判断是否有元素之差小于 indexDiff 的两个元素呢？
* 这就需要使用到TreeSet 利用二叉搜索树结构寻找 [地板元素] 和 [天花板元素] 的特性
*
* 这里你需要知道 TreeSet 和滑动窗口算法结合
* */
public class _220_存在重复元素_III {
    // 如何在窗口 [left, right) 中快速判断是否有元素之差小于 t 的两个元素呢？
    // 这就需要使用到 TreeSet 利用二叉搜索树结构寻找「地板元素」和「天花板元素」的特性了
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> window = new TreeSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            // 为了防止 i == j，所以在扩大窗口之前先判断是否有符合题意的索引对 (i, j)
            // 查找略大于 nums[right] 的那个元素
            Integer ceiling = window.ceiling(nums[right]);
            if (ceiling != null && (long) ceiling - nums[right] <= valueDiff) {
                return true;
            }

            // 查找略小于 nums[right] 的那个元素
            Integer floor = window.floor(nums[right]);
            if (floor != null && (long) nums[right] - floor <= valueDiff) {
                return true;
            }

            // 扩大窗口
            window.add(nums[right]);
            right++;

            // 缩小窗口
            if (right - left > indexDiff) {
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
