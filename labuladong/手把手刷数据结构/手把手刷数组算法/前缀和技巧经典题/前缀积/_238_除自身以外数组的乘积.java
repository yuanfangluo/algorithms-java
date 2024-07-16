package labuladong.手把手刷数据结构.手把手刷数组算法.前缀和技巧经典题.前缀积;

/*
* https://leetcode.cn/problems/product-of-array-except-self/
* */
public class _238_除自身以外数组的乘积 {

    // 思路：构造一个 prefix 数组记录「前缀积」，再用一个 suffix 记录「后缀积」，根据前缀和后缀积就能计算除了当前元素之外其他元素的积
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 从左到右的前缀积，prefix[i] 是 nums[0..i] 的元素积
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        // 从右到左的前缀积，suffix[i] 是 nums[i..n-1] 的元素积
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        // 结果数组
        int[] res = new int[n];
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            // 除了 nums[i] 自己的元素积就是 nums[i] 左侧和右侧所有元素之积
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        return res;
    }
}
