package labuladong.手把手刷数据结构.手把手刷数组算法.数组双指针经典题;

/*
* https://leetcode.cn/problems/squares-of-a-sorted-array/?show=1
*
* */
public class _977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
        int i = 0, j = n - 1;
        int[] res = new int[n];
        // 得到的有序结果是降序的
        int p = n - 1;
        // 执行双指针合并有序数组的逻辑
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
        }
        return res;
    }

    public int[] sortedSquares11(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        int[] res = new int[n];
        int p = n - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                p--;
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                p--;
                j--;
            }
        }
        return res;
    }

}
