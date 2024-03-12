package LeetCode._2_数组._1_双指针._1_快慢指针._2_滑动窗口;

import java.util.ArrayList;

/*
* https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/?show=1
*
* 因为都是正整数，这题可以用滑动窗口技巧，相当于问你数组 nums = [1,2,...,target] 中和为 target 的子数组
*
* 1. 什么时候扩大窗口？
* 当窗口中元素和小于target
* 2. 什么时候缩小窗口？
* 当窗口中元素和大于target
* 3. 什么时候得到一个合法的答案？
* 当窗口中元素和等于target，并且元素个数大于等于2
*
* */
public class 剑指Offer_57_II_和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1;
        int windowSum = 0;

        ArrayList<int[]> res = new ArrayList<>();

        while (right <= target) {
            // 扩大窗口
            windowSum += right;
            right++;

            // 缩小窗口
            while (windowSum > target) {
                windowSum -= left;
                left++;
            }

            // 窗口元素和为 target，且至少包含两个元素
            if (windowSum == target && right - left >= 2) {
                int[] nums = new int[right - left];
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = left + i;
                }
                res.add(nums);
            }
        }

        // 把 Java 的 List 转化成 int[]
        int[][] arr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

}
