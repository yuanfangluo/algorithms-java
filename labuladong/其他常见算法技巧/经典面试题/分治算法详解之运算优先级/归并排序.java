package labuladong.其他常见算法技巧.经典面试题.分治算法详解之运算优先级;

public class 归并排序 {
    void sort(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        // ****** 分 ******
        // 对数组的两部分分别排序
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        // ****** 治 ******
        // 合并两个排好序的子数组
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'merge'");
    }
}
