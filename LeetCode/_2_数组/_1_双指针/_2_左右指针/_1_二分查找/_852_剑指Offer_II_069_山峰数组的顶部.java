package LeetCode._2_数组._1_双指针._2_左右指针._1_二分查找;


/*
* https://leetcode.cn/problems/B1IidL/?show=1
*
*
* */
public class _852_剑指Offer_II_069_山峰数组的顶部 {
    public int peakIndexInMountainArray(int[] nums) {
        // 取两端都闭的二分搜索
        int left = 0, right = nums.length - 1;
        // 因为题目必然有解，所以设置 left == right 为结束条件
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // mid 本身就是峰值或其左侧有一个峰值
                right = mid;
            } else {
                // mid 右侧有一个峰值
                left = mid + 1;
            }
        }
        return left;
    }
}
