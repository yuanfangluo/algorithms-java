package labuladong.手把手刷数据结构.数组.双指针技巧秒杀七道数组题目.左右指针.二分查找;

public class 二分查找 {
    int binarySearch(int[] nums, int target) {
        // 一左一右两个指针相向而行
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            // int mid = (right + left) / 2;
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid; 
            else if (nums[mid] < target)
                left = mid + 1; 
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
}
