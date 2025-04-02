package labuladong._4_其他常见算法技巧.经典面试题.烧饼排序算法;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/pancake-sorting/
public class _969_煎饼排序 {
    // 首先这题有递归的性质
    // 1、找到 n 个饼中最大的那个。

    // 2、把这个最大的饼移到最底下。

    // 3、递归调用 pancakeSort(A, n - 1)。

    // base case：n == 1 时，排序 1 个饼时不需要翻转。
    // 如何设法将某块烧饼翻到最后呢？
    // 其实很简单，比如第 3 块饼是最大的，我们想把它换到最后，也就是换到第 n 块。可以这样操作

    // 1、用锅铲将前 3 块饼翻转一下，这样最大的饼就翻到了最上面。
    // 2、用锅铲将前 n 块饼全部翻转一下，这样最大的饼就翻到了第 n 块。

    // 算法的时间复杂度很容易计算，因为递归调用的次数是 n，每次递归调用都需要一次 for 循环，时间复杂度是 O(n)，所以总的复杂度是 O(n^2)。

    class Solution {
        // 记录反转操作序列
        LinkedList<Integer> res = new LinkedList<>();

        List<Integer> pancakeSort(int[] cakes) {
            sort(cakes, cakes.length);
            return res;
        }

        void sort(int[] cakes, int n) {
            // base case
            if (n == 1)
                return;

            // 寻找最大饼的索引
            int maxCake = 0;
            int maxCakeIndex = 0;
            for (int i = 0; i < n; i++)
                if (cakes[i] > maxCake) {
                    maxCakeIndex = i;
                    maxCake = cakes[i];
                }

            // 第一次翻转，将最大饼翻到最上面
            reverse(cakes, 0, maxCakeIndex);
            res.add(maxCakeIndex + 1);
            // 第二次翻转，将最大饼翻到最下面
            reverse(cakes, 0, n - 1);
            res.add(n);

            // 递归调用
            sort(cakes, n - 1);
        }

        void reverse(int[] arr, int i, int j) {
            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

    // 如果要求你的算法计算排序烧饼的最短操作序列，你该如何计算呢？
    // 或者说，解决这种求最优解法的问题，核心思路什么，一定需要使用什么算法技巧呢？
    
}
