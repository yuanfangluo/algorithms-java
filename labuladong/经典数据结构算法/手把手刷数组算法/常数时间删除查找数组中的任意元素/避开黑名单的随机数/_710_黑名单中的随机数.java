package labuladong.经典数据结构算法.手把手刷数组算法.常数时间删除查找数组中的任意元素.避开黑名单的随机数;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/random-pick-with-blacklist/
public class _710_黑名单中的随机数 {
    class Solution {
        int W;
        Map<Integer, Integer> mapping;

        // 总共的个数是N
        // 黑名单的个数是 B = blacklist.length
        // 白名单的个数是 W = N - B
        // 将在[0, W)里面在黑名单里面的放在[W, N) 的属于白名单的位置上，并且做好绑定
        public void Solution2(int N, int[] blacklist) {
            int B = blacklist.length;
            int W = N - B;
            // 首先将黑名单放进map
            mapping = new HashMap<>();
            for (int b : blacklist) {
                // 这个代表黑名单的map
                mapping.put(b, 666);
            }
            // 将在[0, W)里面在黑名单里面的放在[W, N) 的属于白名单的位置上，并且做好绑定
            int p = N - 1;
            for (int b : blacklist) {
                if (b < W) { // 黑名单在[0, W)里面
                    while (mapping.containsKey(p)) {
                        p--;
                    }
                    // 到这里就代表后面的位置不在黑名单
                    mapping.put(b, p);
                    p--;
                }
            }
        }

        public Solution(int N, int[] blacklist) {
            W = N - blacklist.length;
            mapping = new HashMap<>();
            for (int b : blacklist) {
                mapping.put(b, 666);
            }
            int last = N - 1;
            for (int b : blacklist) {
                // 如果 b 已经在区间 [sz, N)
                // 可以直接忽略
                if (b >= W) {
                    continue;
                }
                while (mapping.containsKey(last)) {
                    last--;
                }
                mapping.put(b, last);
                last--;
            }
        }

        public int pick() {
            // 随机选取一个索引
            int index = (int) (Math.random() * W);
            // 这个索引命中了黑名单，
            // 需要被映射到其他位置
            if (mapping.containsKey(index)) {
                return mapping.get(index);
            }
            // 若没命中黑名单，则直接返回
            return index;
        }
    }
}
