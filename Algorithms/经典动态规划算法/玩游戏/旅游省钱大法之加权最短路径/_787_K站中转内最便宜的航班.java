package Algorithms.经典动态规划算法.玩游戏.旅游省钱大法之加权最短路径;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/cheapest-flights-within-k-stops/
public class _787_K站中转内最便宜的航班 {
    // 哈希分组+备忘录 递归
    class Solution {
        // 备忘录
        int[][] memo;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            memo = new int[n + 1][k + 1];
            for (int i = 0; i < flights.length; i++) {
                int from = flights[i][0];
                int to = flights[i][1];
                int price = flights[i][2];
                map.putIfAbsent(from, new HashMap<>());
                map.get(from).put(to, price);
            }

            for (int[] a : memo) {
                Arrays.fill(a, -2);
            }

            return dp(flights, src, dst, k);
        }

        // 从src出发，k步之内到达dst的最小花费
        public int dp(int[][] flights, int src, int dst, int k) {
            if (k < 0) {
                return src == dst ? 0 : -1;
            }

            // 如果等于dst直接返回
            if (src == dst) {
                return 0;
            }

            if (memo[src][k] != -2) {
                return memo[src][k];
            }

            // 是否包含直达的路径
            Map<Integer, Integer> path = map.get(src);

            // 不可直达
            if (path == null) {
                return -1;
            }
                
            int min = Integer.MAX_VALUE;
            // 遍历所有直达的路径
            for (Map.Entry<Integer, Integer> entry : path.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                int res = dp(flights, key, dst, k - 1);
                if (res >= 0) {
                    min = Math.min(min, res + val);
                }
            }

            min = (min == Integer.MAX_VALUE) ? -1 : min;
            memo[src][k] = min;
            return min;
        }
    }
}
