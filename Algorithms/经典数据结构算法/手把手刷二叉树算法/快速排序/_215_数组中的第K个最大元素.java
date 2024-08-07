package Algorithms.经典数据结构算法.手把手刷二叉树算法.快速排序;

import java.util.PriorityQueue;
import java.util.Random;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/
public class _215_数组中的第K个最大元素 {
    // 一种是二叉堆（优先队列）
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
            }
            while (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    // 一种是快速选择算法
    class Solution2 {
        // 快速选择算法
        int findKthLargest(int[] nums, int k) {
            // 首先随机打乱数组
            shuffle(nums);
            int lo = 0, hi = nums.length - 1;
            // 转化成「排名第 k 的元素」
            k = nums.length - k;
            while (lo <= hi) {
                // 在 nums[lo..hi] 中选一个切分点
                int p = partition(nums, lo, hi);
                if (p < k) {
                    // 第 k 大的元素在 nums[p+1..hi] 中
                    lo = p + 1;
                } else if (p > k) {
                    // 第 k 大的元素在 nums[lo..p-1] 中
                    hi = p - 1;
                } else {
                    // 找到第 k 大元素
                    return nums[p];
                }
            }
            return -1;
        }

        // 对 nums[lo..hi] 进行切分
        int partition(int[] nums, int lo, int hi) {
            int pivot = nums[lo];
            // 关于区间的边界控制需格外小心，稍有不慎就会出错
            // 我这里把 i, j 定义为开区间，同时定义：
            // [lo, i) <= pivot；(j, hi] > pivot
            // 之后都要正确维护这个边界区间的定义
            int i = lo + 1, j = hi;
            // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
            while (i <= j) {
                while (i < hi && nums[i] <= pivot) {
                    i++;
                    // 此 while 结束时恰好 nums[i] > pivot
                }
                while (j > lo && nums[j] > pivot) {
                    j--;
                    // 此 while 结束时恰好 nums[j] <= pivot
                }

                if (i >= j) {
                    break;
                }
                // 此时 [lo, i) <= pivot && (j, hi] > pivot
                // 交换 nums[j] 和 nums[i]
                swap(nums, i, j);
                // 此时 [lo, i] <= pivot && [j, hi] > pivot
            }
            // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
            swap(nums, lo, j);
            return j;
        }

        // 洗牌算法，将输入的数组随机打乱
        void shuffle(int[] nums) {
            Random rand = new Random();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // 生成 [i, n - 1] 的随机数
                int r = i + rand.nextInt(n - i);
                swap(nums, i, r);
            }
        }

        // 原地交换数组中的两个元素
        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
