package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/flip-game/
public class _293_翻转游戏 {
    class Solution {
        public List<String> generatePossibleNextMoves(String currentState) {
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
    }
}
