package Algorithms._0_核心框架汇总.滑动窗口算法框架.找所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/
public class _438_找到字符串中所有字母异位词 {
    // 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
    class Solution {
        public List<Integer> findAnagrams(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            int valid = 0;
            List<Integer> res = new ArrayList<>();
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
                    // 在这里符合条件，把起始索引加入 res
                    if (valid == need.size()) {
                        res.add(left);
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
            return res;
        }
    }
}
