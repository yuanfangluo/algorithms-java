package Algorithms.经典数据结构算法.手把手刷二叉树算法.快速排序;

import java.util.Arrays;

public class 快速排序 {
    // 归并排序：先把左半边数组排好序，再把右半边数组排好序，然后把两半数组合并。
    // 快速排序是先将一个元素排好序，然后再将剩下的元素排好序。
    // 理想的总时间复杂度为 O(NlogN)
    void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, lo, hi);
        // 去左右子数组进行切分
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    int partition(int[] nums, int lo, int hi) {
        
        return 0;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
