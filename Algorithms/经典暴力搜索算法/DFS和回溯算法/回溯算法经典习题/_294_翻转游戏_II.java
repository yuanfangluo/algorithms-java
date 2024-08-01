package Algorithms.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/flip-game-ii/
public class _294_翻转游戏_II {
    class Solution {
        // 直接把 293 的代码 copy 过来，生成所有可能的下一步
        List<String> generatePossibleNextMoves(String currentState) {
            List<String> res = new ArrayList<>();
            char[] arr = currentState.toCharArray();
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == '+' && arr[i - 1] == '+') {
                    // 做选择
                    arr[i] = '-';
                    arr[i - 1] = '-';
                    res.add(new String(arr));
                    // 撤销选择
                    arr[i] = '+';
                    arr[i - 1] = '+';
                }
            }
            return res;
        }

        // 备忘录，key 为字符串，value 为 boolean，表示在该局面下先手是否可能赢
        Map<String, Boolean> memo = new HashMap<>();

        public boolean canWin(String currentState) {
            // 记入备忘录
            memo.clear();
            return dp(currentState);
        }

        // 定义：输入字符串 s，返回在此局面下先手是否可能赢
        boolean dp(String s) {
            if (memo.containsKey(s)) {
                // 之前遇到过这种局面，直接返回结果
                return memo.get(s);
            }
            // 没有出现过的局面，继续枚举下一步的所有可能，看是否存在一种情况，让对手输
            boolean res = false;
            List<String> nextStates = generatePossibleNextMoves(s);
            for (String nextState : nextStates) {
                boolean win = dp(nextState);
                // 对手输了，我就赢了
                // 只要有一种情况让对手输，我就赢了
                // 后序位置
                if (!win) {
                    res = true;
                    break;
                }
            }
            // 记入备忘录
            memo.put(s, res);
            return res;
        }
    }
}
