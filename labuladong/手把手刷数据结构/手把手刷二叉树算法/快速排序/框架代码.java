package labuladong.手把手刷数据结构.手把手刷二叉树算法.快速排序;

import java.util.Arrays;

public class 框架代码 {
    // 归并排序：先把左半边数组排好序，再把右半边数组排好序，然后把两半数组合并。
    // 快速排序是先将一个元素排好序，然后再将剩下的元素排好序。
    // 理想的总时间复杂度为 O(NlogN)

    public static void main(String[] args) {
        int[] array = new int[] {4, 1, 6, 3, 2, 5};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    static void sort(int[] nums, int lo, int hi) {
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

    static int partition(int[] nums, int lo, int hi) {
        return 0;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
