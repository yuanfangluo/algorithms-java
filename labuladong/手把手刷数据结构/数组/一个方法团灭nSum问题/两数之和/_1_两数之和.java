package labuladong.手把手刷数据结构.数组.一个方法团灭nSum问题.两数之和;

import java.util.*;

/*
* https://leetcode.cn/problems/two-sum/description/
*
* */
public class _1_两数之和 {

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) return new int[]{index, i};
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        // 左右指针
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 根据 sum 和 target 的比较，移动左右指针
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else if (sum == target) {
                return new int[] { nums[lo], nums[hi] };
            }
        }
        return new int[] {};
    }

    // 泛化一下，求两数之和的元素，不是索引
    // 这个函数的时间复杂度非常容易看出来，双指针操作的部分虽然有那么多 while 循环，但是时间复杂度还是 O(N)，
    // 而排序的时间复杂度是 O(NlogN)，
    // 所以这个函数的时间复杂度是 O(NlogN)。
    List<List<Integer>> twoSumTarget(int[] nums, int target) {
        // nums 数组必须有序
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int left = nums[lo], right = nums[hi];
            int sum = left + right;
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                List<Integer> item = new ArrayList<>();
                item.add(left);
                item.add(right);
                res.add(item);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }

    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // nums 数组必须有序
        Arrays.sort(nums);
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int left = nums[lo], right = nums[hi];
            int sum = left + right;
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                List<Integer> item = new ArrayList<>();
                item.add(left);
                item.add(right);
                res.add(item);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }
}
