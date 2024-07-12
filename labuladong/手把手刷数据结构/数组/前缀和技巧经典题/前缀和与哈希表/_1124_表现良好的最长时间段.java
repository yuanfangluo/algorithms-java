package labuladong.手把手刷数据结构.数组.前缀和技巧经典题.前缀和与哈希表;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.cn/problems/longest-well-performing-interval/
*
* */
public class _1124_表现良好的最长时间段 {

    /*
    * 题目说 hours[i] 以 8 作为分界线，那么我们就要条件反射地想到对数据进行「归一化」处理，
    * 比如把所有大于 8 的元素视为 +1，把所有小于 8 的元素视为 -1，
    * 这样一来，这道题就改造成了：计算数组中元素和大于 0 的子数组的最大长度。
    *
    * 考察前缀和 + 哈希表的组合场景。
    * */
    public int longestWPI11(int[] hours) {
        int n = hours.length;
        int res = 0;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i -1] + (hours[i-1] > 8 ? 1 : -1);
            map.putIfAbsent(preSum[i], i);
            if (preSum[i] > 0) {
                res = Math.max(res, i);
            } else {
                if (map.containsKey(preSum[i] - 1)) {
                    int j = map.get(preSum[i] - 1);
                    res  = Math.max(res, i - j);
                }
            }
        }
        return res;
    }



    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 前缀和到索引的映射，方便快速查找所需的前缀和
        Map<Integer, Integer> valToIndex = new HashMap<>();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            // 计算 nums[0..i-1] 的前缀和
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);

            // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if (!valToIndex.containsKey(preSum[i])) {
                valToIndex.put(preSum[i], i);
            } else {
                // 因为题目想找长度最大的子数组，valToIndex 中的索引应尽可能小，
                // 所以这里什么都不做
            }

            // 现在我们想找 hours[0..i-1] 中元素和大于 0 的子数组
            // 这就要根据 preSum[i] 的正负分情况讨论了
            if (preSum[i] > 0) {
                // preSum[i] 为正，说明 hours[0..i-1] 都是「表现良好的时间段」
                res = Math.max(res, i);
            } else {
                // preSum[i] 为负，需要寻找一个 j 使得 preSum[i] - preSum[j] > 0
                // 且 j 应该尽可能小，即寻找 preSum[j] == preSum[i] - 1
                if (valToIndex.containsKey(preSum[i] - 1)) {
                    int j = valToIndex.get(preSum[i] - 1);
                    res = Math.max(res, i - j);
                }
            }
        }
        return res;
    }
}
