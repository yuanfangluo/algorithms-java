package Algorithms._1_经典数据结构算法.手把手刷数组算法.二分搜索算法经典习题;


import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.cn/problems/find-k-closest-elements/?show=1
*
* */
public class _658_找到K个最接近的元素 {
    // 思路：
    // （1）用 二分查找算法详解 中介绍的搜索左侧边界的二分查找算法找到 x 的位置，然后用 数组双指针技巧汇总 中解决 5. 最长回文子串 的从中间向两端的双指针算法找到这 k 个元素。
    // （2）题目要求返回的结果必须按升序排序，所以我们必须用 LinkedList 来从两端添加结果，使得结果有序
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 二分搜索找到 x 的左侧边界位置
        int p = left_bound(arr, x);
        // 两端都开的区间 (left, right)
        int left = p - 1, right = p;
        LinkedList<Integer> res = new LinkedList<>();
        // 扩展区间，直到区间内包含 k 个元素
        while ((right - left - 1) < k) {
            if (left == -1) {
                res.addLast(arr[right]);
                right++;
            } else if (right == arr.length) {
                res.addFirst(arr[left]);
                left--;
            } else if (x - arr[left] > arr[right] - x) {
                res.addLast(arr[right]);
                right++;
            } else {
                res.addFirst(arr[left]);
                left--;
            }
        }
        return res;
    }

    // 搜索左侧边界的二分搜索
    int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
}
