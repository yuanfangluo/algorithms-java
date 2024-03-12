package LeetCode._2_数组._1_双指针._2_左右指针._1_二分查找;


/*
* https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/?show=1
*
* 你可以观察 nums[mid] 和 mid 的关系，如果 nums[mid] 和 mid 相等，则缺失的元素在右半边，
* 如果 nums[mid] 和 mid 不相等，则缺失的元素在左半边
*
*
* */
public class 剑指Offer_53_II_0到n减1中缺失的数字 {

    public int missingNumber(int[] nums) {
        // 搜索左侧的二分搜索
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                // mid 和 nums[mid] 不对应，说明左边有元素缺失
                right = mid - 1;
            } else {
                // mid 和 nums[mid] 对应，说明元素缺失在右边
                left = mid + 1;
            }
        }
        return left;
    }
}
