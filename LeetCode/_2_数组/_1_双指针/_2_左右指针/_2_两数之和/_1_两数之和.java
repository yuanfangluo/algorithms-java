package LeetCode._2_数组._1_双指针._2_左右指针._2_两数之和;

import java.util.*;

/*
* https://leetcode.cn/problems/two-sum/description/
*
* */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) return new int[]{index, i};
            map.put(nums[i], i);
        }
        return null;
    }

    // 泛化一下，求两数之和的元素，不是索引
    List<List<Integer>> twoSumTarget(int[] nums, int target) {
        // nums 数组必须有序
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        ArrayList<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int left = nums[lo], right = nums[hi];
            int sum = left + right;
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                ArrayList<Integer> item = new ArrayList<>();
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
