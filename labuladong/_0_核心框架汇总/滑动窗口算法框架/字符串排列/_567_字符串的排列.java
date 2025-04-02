package labuladong._0_核心框架汇总.滑动窗口算法框架.字符串排列;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/permutation-in-string/description/
public class _567_字符串的排列 {
    class Solution {
        // 判断 s 是否包含 t 的排列
        // t的排列之一是s的子串
        public boolean checkInclusion(String t, String s) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            int valid = 0;
            while (right < s.length()) {
                // c 是将移入窗口的字符
                char c = s.charAt(right);
                // 右移窗口
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    // Java 中的 Integer 和 String 这种包装类不能直接用 == 进行相等判断，而应该使用类的 equals 方法
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                // 判断左侧窗口是否要收缩
                while ((right - left) >= t.length()) {
                    // 在这里判断是否找到了合法的子串
                    if (valid == need.size()) {
                        return true;
                    }
                    // d 是将移出窗口的字符
                    char d = s.charAt(left);
                    // 左移窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return false;
        }
    }
}
