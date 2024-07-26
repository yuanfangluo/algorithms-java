package labuladong.经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/advantage-shuffle/
public class _870_优势洗牌 {
    // 这题就像田忌赛马的情景，nums1 就是田忌的马，nums2 就是齐王的马，数组中的元素就是马的战斗力，
    // 你就是谋士孙膑，请你帮田忌安排赛马顺序，使胜场最多。
    // 最优策略是将齐王和田忌的马按照战斗力排序，然后按照战斗力排名一一对比：
    // 如果田忌的马能赢，那就比赛，如果赢不了，那就换个垫底的来送人头，保存实力。

    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (pair1, pair2) -> {
                        return pair2[1] - pair1[1];
                    });
            int n = nums2.length;
            for (int i = 0; i < n; i++) {
                pq.offer(new int[] { i, nums2[i] });
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
    }
}
