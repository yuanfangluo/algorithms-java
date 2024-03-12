package LeetCode._2_数组._1_双指针._1_快慢指针._2_滑动窗口;

/*
* https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/?show=1
*
* */
public class _1658_将x减到0的最小操作数 {

    /*
    * 这道题等价于让你寻找 nums 中元素和为 sum(nums) - x 的最长子数组
    * */
    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        // 滑动窗口需要寻找的子数组目标和
        int target = sum - x;

        int left = 0, right = 0;
        // 记录窗口内所有元素和
        int windowSum = 0;
        // 记录目标子数组的最大长度
        int maxLen = Integer.MIN_VALUE;
        // 开始执行滑动窗口框架
        while (right < nums.length) {
            // 扩大窗口
            windowSum += nums[right];
            right++;

            while (windowSum > target && left < right) {
                // 缩小窗口
                windowSum -= nums[left];
                left++;
            }
            // 寻找目标子数组
            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left);
            }
        }
        // 目标子数组的最大长度可以推导出需要删除的字符数量
        return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
    }

}
