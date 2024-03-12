package LeetCode._2_数组._1_双指针._2_左右指针._2_两数之和;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* https://leetcode.cn/problems/4sum/
*
*
*
* */
public class _18_四数之和 {

    public static void main(String[] args) {
        System.out.println(
                new _18_四数之和().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296)
        );
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 至少是2sum， 且数字大小不应该小于 n
        if (n < 2 || sz< n) return res;

        // 2Sum
        if (n == 2) {
            // 双指针
            int lo = start, hi = sz - 1;
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
        } else { // n>2,递归计算 (n-1)Sum 的结果
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1,target-nums[i]);
                for (List<Integer> arr : sub) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz -1 && nums[i] == nums[i+1]) i++;
            }
        }
        return res;
    }

}
