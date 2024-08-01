package Algorithms.其他常见算法技巧.经典面试题.斗地主也能玩出算法;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/split-array-into-consecutive-subsequences/
public class _659_分割数组为连续子序列 {
    // 1. 首先统计各个数字的个数
    // 2. 一个数字可以接在前面，也可以作为新序列的第一个元素
    // 如果两个都可以，需要优先判断能否接在前面序列的后面，如果不行，再判断是否可以作为新序列的开头
    // 3. 维护两个hashmap，一个数组记录每个数字的个数，一个数组记录每个数字还需要多少个
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> need = new HashMap<>();

            // 统计 nums 中元素的频率
            for (int v : nums) {
                freq.put(v, freq.getOrDefault(v, 0) + 1);
            }

            for (int v : nums) {
                if (freq.get(v) == 0) {
                    // 已经被用到其他子序列中
                    continue;
                }

                // 先判断 v 是否能接到其他子序列后面
                if (need.containsKey(v) && need.get(v) > 0) {
                    // v 可以接到之前的某个序列后面
                    freq.put(v, freq.get(v) - 1);
                    // 对 v 的需求减一
                    need.put(v, need.get(v) - 1);
                    // 对 v + 1 的需求加一
                    need.put(v + 1, need.getOrDefault(v + 1, 0) + 1);
                } else if (freq.getOrDefault(v, 0) > 0 &&
                        freq.getOrDefault(v + 1, 0) > 0 &&
                        freq.getOrDefault(v + 2, 0) > 0) {
                    // 将 v 作为开头，新建一个长度为 3 的子序列 [v, v+1, v+2]
                    freq.put(v, freq.get(v) - 1);
                    freq.put(v + 1, freq.get(v + 1) - 1);
                    freq.put(v + 2, freq.get(v + 2) - 1);
                    // 对 v + 3 的需求加一
                    need.put(v + 3, need.getOrDefault(v + 3, 0) + 1);
                } else {
                    // 两种情况都不符合，则无法分配
                    return false;
                }
            }

            return true;
        }
    }
}
