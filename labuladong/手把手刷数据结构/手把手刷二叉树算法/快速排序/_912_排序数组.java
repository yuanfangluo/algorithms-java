package labuladong.手把手刷数据结构.手把手刷二叉树算法.快速排序;

public class _912_排序数组 {
    public int[] sortArray(int[] nums) {
        // 归并排序对数组进行原地排序
        Quick.sort(nums);
        return nums;
    }
}
