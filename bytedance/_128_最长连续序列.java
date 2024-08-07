// https://leetcode.cn/problems/longest-consecutive-sequence/

import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列 {
    // 如果使用排序的方法需要时间复杂度为O(nlogn)
    // 因此需要换思路
    // 想找连续序列，首先要找到这个连续序列的开头元素，然后递增，看看之后有多少个元素还在 nums 中，即可得到最长连续序列的长度了。
    class Solution {
        public int longestConsecutive(int[] nums) {
            // 转化成哈希集合，方便快速查找是否存在某个元素
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;
            for (int num : nums) {
                if (set.contains(num - 1)) {
                    // num 不是某个连续子序列的第一个，跳过
                    continue;
                }

                // num 是某个连续子序列的第一个，开始向上计算连续子序列的长度
                int curNum = num;
                int curlen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curlen++;
                }
                res = Math.max(curlen, res);
            }
            return res;
        }
    }
}
