package labuladong.手把手刷动态规划.动态规划基本技巧.最长递增子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.cn/problems/russian-doll-envelopes/
public class _354_俄罗斯套娃信封问题 {
    // 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序；
    // 之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
    // envelopes = [[w, h], [w, h]...]

    class Solution1 {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            });

            // 对高度数组寻找 LIS
            List<Integer> tempMax = new ArrayList<>();
            for (int i = 0; i < envelopes.length; i++) {
                // 二分查找 tempMax 中第一个大于等于 envelopes[i][1] 的元素
                int index = Collections.binarySearch(tempMax, envelopes[i][1]);
                if (index < 0) {
                    index = -(index + 1);
                }

                if (index == tempMax.size()) {
                    tempMax.add(envelopes[i][1]);
                } else {
                    tempMax.set(index, envelopes[i][1]);
                }
            }
            return tempMax.size();
        }
    }

    class Solution2 {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            // 按宽度升序排列，如果宽度一样，则按高度降序排列
            Arrays.sort(envelopes, (int[] a, int[] b) -> {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            });

            // 对高度数组寻找 LIS
            int[] height = new int[n];
            for (int i = 0; i < n; i++)
                height[i] = envelopes[i][1];

            return lengthOfLIS(height);
        }

        int lengthOfLIS(int[] nums) {
            int[] top = new int[nums.length];
            // 牌堆数初始化为 0
            int piles = 0;
            for (int i = 0; i < nums.length; i++) {
                // 要处理的扑克牌
                int poker = nums[i];

                /***** 搜索左侧边界的二分查找 *****/
                int left = 0, right = piles;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (top[mid] > poker) {
                        right = mid;
                    } else if (top[mid] < poker) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                /*********************************/

                // 没找到合适的牌堆，新建一堆
                if (left == piles)
                    piles++;
                // 把这张牌放到牌堆顶
                top[left] = poker;
            }
            // 牌堆数就是 LIS 长度
            return piles;
        }
    }
}
