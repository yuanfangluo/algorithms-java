package labuladong.经典数据结构算法.手把手刷数组算法.一个方法团灭nSum问题.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import labuladong.经典数据结构算法.手把手刷数组算法.一个方法团灭nSum问题.两数之和._1_两数之和;

/*
* https://leetcode.cn/problems/3sum/
*
* */
public class _15_三数之和 {
    /* 计算数组 nums 中所有和为 0 的三元组 */
    // 依赖2Sum
    public List<List<Integer>> threeSum(int[] nums) {
        // 求和为 0 的三元组
        return threeSumTarget(nums, 0);
    }

    /* 计算数组 nums 中所有和为 target 的三元组 */
    // 排序的复杂度为 O(NlogN)，twoSumTarget 函数中的双指针操作为 O(N)，
    // threeSumTarget 函数在 for 循环中调用 twoSumTarget 
    // 所以总的时间复杂度就是 O(NlogN + N^2) = O(N^2)。
    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // 数组得排个序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 threeSum 的第一个数
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 twoSum
            _1_两数之和 twoSum = new _1_两数之和();
            List<List<Integer>> tuples = twoSum.twoSumTarget(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    /* 计算数组 nums 中所有和为 target 的三元组 */
    public List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
        // 数组得排个序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 threeSum 的第一个数
        for (int i = start; i < n; i++) {
            // 对 target - nums[i] 计算 twoSum
            _1_两数之和 twoSum = new _1_两数之和();
            List<List<Integer>> tuples = twoSum.twoSumTarget(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

}
