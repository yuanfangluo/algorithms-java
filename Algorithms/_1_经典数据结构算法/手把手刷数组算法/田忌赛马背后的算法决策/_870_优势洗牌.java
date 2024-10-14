package Algorithms._1_经典数据结构算法.手把手刷数组算法.田忌赛马背后的算法决策;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/advantage-shuffle/
public class _870_优势洗牌 {

    // 将齐王和田忌的马按照战斗力排序，然后按照排名一一对比。
    // 如果田忌的马能赢，那就比赛，如果赢不了，那就换个垫底的来送人头，保存实力。
    // 算法的时间复杂度很好分析，也就是二叉堆和排序的复杂度 O(nlogn)。
    public int[] advantageCount11(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (pair1, pair2)->{
                return pair2[1] - pair1[1];
            }
        );
        int n = nums2.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        // 针对nums1使用双指针
        int left = 0, right = n - 1;
        int[] res = new int[n];
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }


    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 给 nums2 降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                });
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[] { i, nums2[i] });
        }
        // 给 nums1 升序排序
        Arrays.sort(nums1);

        // nums1[left] 是最小值，nums1[right] 是最大值
        int left = 0, right = n - 1;
        int[] res = new int[n];

        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            // maxval 是 nums2 中的最大值，i 是对应索引
            // { i, nums2[i] }
            int i = pair[0], maxval = pair[1];
            if (maxval < nums1[right]) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[i] = nums1[right];
                right--;
            } else {
                // 否则用最小值混一下，养精蓄锐
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
