package labuladong.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/shopping-offers/
public class _638_大礼包 {
    class Solution {
        List<Integer> price;
        List<List<Integer>> specials;

        // 记录当前购买大礼包的花费
        int trackCost = 0;
        // 记录最小花费
        int minCost = Integer.MAX_VALUE;

        public int shoppingOffers(List<Integer> price, List<List<Integer>> specials, List<Integer> needs) {
            // 去除那些大礼包还不如单买更便宜的情况
            List<List<Integer>> newSpecials = new ArrayList<>();
            for (int i = 0; i < specials.size(); i++) {
                List<Integer> special = specials.get(i);
                // 单买的花费
                int cost = 0;
                for (int j = 0; j < special.size() - 1; j++) {
                    cost += special.get(j) * price.get(j);
                }
                // 如果单买的花费大于礼包价格，就将这个礼包加到新的礼包列表中
                if (cost > special.get(special.size() - 1)) {
                    newSpecials.add(special);
                }
            }
            this.price = price;
            this.specials = newSpecials;
            backtrack(needs, 0);
            return minCost;
        }

        // 回溯算法核心框架
        // 整体逻辑可以类比「元素无重可复选」的组合问题
        void backtrack(List<Integer> needs, int start) {
            if (trackCost >= minCost) {
                // 剪枝
                return;
            }
            // 是否购买了大礼包的初始值
            boolean haveUsedSpecial = false;
            // 组合问题需要从 start 开始遍历
            for (int i = start; i < specials.size(); i++) {
                List<Integer> targetSpecial = specials.get(i);
                if (!canUseSpecial(targetSpecial, needs)) {
                    continue;
                }
                // 代表购买了大礼包
                haveUsedSpecial = true;

                // 可以买 specials[i] 这个大礼包
                // 做出购买的选择
                for (int j = 0; j < needs.size(); j++) {
                    needs.set(j, needs.get(j) - targetSpecial.get(j));
                }
                // 记录大礼包花费
                trackCost += targetSpecial.get(targetSpecial.size() - 1);

                // 因为每个元素可以复选，所以下次回溯依然从 i 开始
                backtrack(needs, i);

                // 撤销购买的选择
                for (int j = 0; j < needs.size(); j++) {
                    needs.set(j, needs.get(j) + targetSpecial.get(j));
                }
                trackCost -= targetSpecial.get(targetSpecial.size() - 1);
            }

            // 没有大礼包可以购买，只能单买
            if (!haveUsedSpecial) {
                // 无法使用大礼包，只能单买
                // 计算单买的花费
                int sum = 0;
                for (int i = 0; i < needs.size(); i++) {
                    sum += needs.get(i) * price.get(i);
                }
                // 更新最新的最小花费
                // 单买的价格加上之前的大礼包的价格
                minCost = Math.min(minCost, sum + trackCost);
            }
        }

        // 检查当前大礼包是否可以购买
        boolean canUseSpecial(List<Integer> special, List<Integer> need) {
            for (int i = 0; i < need.size(); i++) {
                // 大礼包中的某个物品数量大于需求，无法购买
                if (need.get(i) < special.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
