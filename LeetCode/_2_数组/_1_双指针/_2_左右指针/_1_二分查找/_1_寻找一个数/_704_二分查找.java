package LeetCode._2_数组._1_双指针._2_左右指针._1_二分查找._1_寻找一个数;

/*
* https://leetcode.cn/problems/binary-search/description/
* 分析二分查找的一个技巧是：不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节
* */
public class _704_二分查找 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
               right = mid -1;
            }
        }
        return -1;
    }
}
