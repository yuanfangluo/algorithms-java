package Algorithms._4_其他常见算法技巧.经典面试题.分治算法详解之运算优先级;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/different-ways-to-add-parentheses/
public class _241_为运算表达式设计优先级 {
    class Solution {
        // 备忘录
        HashMap<String, List<Integer>> memo = new HashMap<>();
        public List<Integer> diffWaysToCompute(String input) {
            // 避免重复计算
            if (memo.containsKey(input)) {
                return memo.get(input);
            }
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                // 扫描算式 input 中的运算符
                if (c == '-' || c == '*' || c == '+') {
                    // ****** 分 ******
                    // 以运算符为中心，分割成两个字符串，分别递归计算
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                    // ****** 治 ******
                    // 通过子问题的结果，合成原问题的结果
                    for (int a : left)
                        for (int b : right)
                            if (c == '+')
                                res.add(a + b);
                            else if (c == '-')
                                res.add(a - b);
                            else if (c == '*')
                                res.add(a * b);
                }
            }
            // base case
            // 如果 res 为空，说明算式是一个数字，没有运算符
            if (res.isEmpty()) {
                res.add(Integer.parseInt(input));
            }
            // 将结果添加进备忘录
            memo.put(input, res);
            return res;
        }
    }
}
