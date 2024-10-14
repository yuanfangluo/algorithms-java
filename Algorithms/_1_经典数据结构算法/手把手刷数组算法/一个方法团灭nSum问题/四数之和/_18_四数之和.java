package Algorithms._1_经典数据结构算法.手把手刷数组算法.一个方法团灭nSum问题.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Algorithms._1_经典数据结构算法.手把手刷数组算法.一个方法团灭nSum问题.三数之和._15_三数之和;

/*
* https://leetcode.cn/problems/4sum/
*
* */
public class _18_四数之和 {
    // 依赖3Sum
    // 4Sum 问题就解决了，时间复杂度的分析和之前类似，for 循环中调用了 threeSumTarget 函数，
    // 所以总的时间复杂度就是 O(N^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 fourSum 的第一个数
        for (int i = 0; i < n; i++) {
            _15_三数之和 threeSum = new _15_三数之和();
            // 对 target - nums[i] 计算 threeSum
            List<List<Integer>> triples = threeSum.threeSumTarget(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的三元组，再加上 nums[i] 就是结果四元组
            for (List<Integer> triple : triples) {
                triple.add(nums[i]);
                res.add(triple);
            }
            // fourSum 的第一个数不能重复
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
    
}
